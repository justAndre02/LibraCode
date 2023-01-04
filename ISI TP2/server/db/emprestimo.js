const sql = require("./index");

class Emprestimo{

    /**
     * Faz uma requisição de um livro
     * @param {*} data Data do pedido de emprestimo
     * @param {*} data_devolucao Data da devolução do livro
     * @param {*} Utilizador_id Identificação do utilizador
     * @param {*} Livro_id Identificação do livro
     * @param {*} result Livro requisitado
     */
    static async MakeEmprestimo(data,data_devolucao,Utilizador_id,Livro_id,result) {
        let query = `call Emprestimo("${data}","${data_devolucao}",${Utilizador_id},${Livro_id})`;
        const[rows,fields] = await sql.execute(query);
        if(rows[0]){
            result(rows[0][0].erro,null);
        }else{
            result(null,null);
        }
    }

    /**
     * Cancela uma requisição e remove a da base de dados
     * @param {*} eid Identificação do emprestimo
     * @param {*} result Emprestimo cancelado
     */
    static async CancelEmprestimo(Utilizador_id,eid,result){
        let query = `call CancelEmprestimo(${Utilizador_id},${eid})`;
        const[rows,fields] = await sql.execute(query);
        if(rows[0]){
            result(rows[0][0],null);
        }else{
            result(null,null);   
        }
    }

    /**
     * Chama uma query que vai listar todos os emprestimos
     * @param  {*} result Devolve um erro, caso este exista
     */
    static async GetEmprestimoAll(result) {
        let query = "SELECT * FROM emprestimo";
        const[rows,fields] =  await sql.execute(query);
        //console.table(rows[0]);
        result(null,rows);
    }

    /**
     * Apresenta toda a informação de um emprestimo
     * @param {int} eeid Identificação de um emprestimo
     * @param {*} result Dado correspondido
     */
    static async GetEmprestimoInfo(eid, result) {
        let query = `SELECT * FROM emprestimo WHERE eid = "${eid}" `;
        const[rows,fields] =  await sql.execute(query);
        //console.table(rows[0]);
        result(null,rows);
    }
}

module.exports = Emprestimo