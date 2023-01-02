const livro = require("../../controller/livro_controller");
var router = require("express").Router();

//get todos os livros
router.get("/all", livro.GetAllLivros_get);

//get livros por id
router.get("/:bookID", livro.GetLivroInfo_get);

module.exports = router;