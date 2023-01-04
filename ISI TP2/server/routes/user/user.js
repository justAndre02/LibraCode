const utilizador = require("../../controller/user_controller");
var router = require("express").Router();


//get todos os utilizadores
router.get("/all", utilizador.GetUtilizadorAllDetails_get);

//post para criar um utilizador
router.post("/signup", utilizador.RegisterUtilizador_post);

//get utilizador por id
router.get("/:id", utilizador.GetUtilizadorInfo_get);

//update o nome de um utilizador
router.put("/update/:id",utilizador.UpdateUtilizador_put);

//update o nome de um utilizador
router.put("/updatepass/:id",utilizador.UpdateUtilizadorPassword_put);
  
//delete um utilizador
router.delete("/delete/:id",utilizador.DeleteUtilizador_delete);

//login de um utilizador
router.post("/login",utilizador.GetLogin_post);

<<<<<<< Updated upstream
=======
router.post('/token', utilizador.signupValidation);

//post de um  novo emprestimo
router.post("/make/:Utilizador_id", emprestimo.MakeEmprestimo_post);

//delete de um emprestimo do utilizador atual
router.post("/cancel/:Utilizador_id", emprestimo.CancelEmprestimo_post);

>>>>>>> Stashed changes
module.exports = router;