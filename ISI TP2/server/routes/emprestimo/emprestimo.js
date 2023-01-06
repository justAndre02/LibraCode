const emprestimo = require("../../controller/emprestimo_controller");
var router = require("express").Router();

// Get de todos empréstimos
router.get("/all", emprestimo.GetEmprestimoAll_get);

// Get de todos empréstimos
router.get("/:eid", emprestimo.GetActiveEmprestimo_get);

module.exports = router;