const emprestimo = require("../../controller/emprestimo_controller");
var router = require("express").Router();

//get de todos os emprestimos
router.get('/all', emprestimo.GetEmprestimoAll_get);

//get de um determinado emprestimo
router.get('/:eid', emprestimo.GetEmprestimoInfo_get);

module.exports = router;