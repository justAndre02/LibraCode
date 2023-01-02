const sql = require("./index");

class Livro {
    /**
     * Chama uma query que vai listar todos os livros
     * @param  {*} result Devolve um erro, caso este exista
     */
    static async GetAllLivros(result) {
        let query = "SELECT * FROM livro";
        const[rows,fields] =  await sql.execute(query);
        //console.table(rows[0]);
        result(null,rows);
    }

    /**
     * Apresenta toda a informação de um livro
     * @param {int} bookID Identificação de um livro
     * @param {*} result Dado a ser mudado
     */
    static async GetLivroInfo(bookID, result) {
        let query = `SELECT * FROM livro WHERE bookID = "${bookID}" `;
        const[rows,fields] =  await sql.execute(query);
        //console.table(rows[0]);
        result(null,rows);
    }
}

module.exports = Livro;