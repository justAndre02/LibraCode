const livro = require("../../controller/livro_controller");
var router = require("express").Router();

//get todos os livros
router.get("/all", livro.GetAllLivros_get);

//get livros por id
router.get("/:bookID", livro.GetLivroInfo_get);

//delete livro pelo nome
router.delete("/delete/:bookID", livro.DeleteLivro_delete);

//post de um livro
router.post("/add", livro.AddLivro_post);

module.exports = router;