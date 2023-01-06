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
     * @param {*} Utilizador_id Identificação do utilizador
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
     * Devolve um livro após o ler
     * @param {*} Utilizador_id Identificação do utilizador
     * @param {*} eid Identificação do empréstimo
     * @param {*} result Emprestimo devolvido
     */
    static async EntregaEmprestimo(Utilizador_id,eid,result){
        let query = `call EntregarEmprestimo(${Utilizador_id},${eid})`;
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

    static async GetActiveEmprestimo(eid, result) {
        let query = `call AindaAtiva(${eid})" `;
        const[rows,fields] =  await sql.execute(query);
        //console.table(rows[0]);
        result(null,rows);
    }
}

module.exports = Emprestimo