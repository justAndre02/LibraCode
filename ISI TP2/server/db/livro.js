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

    static async GetAll50Livros(result) {
        let query = "SELECT * FROM livro WHERE bookID < 50";
        const[rows,fields] =  await sql.execute(query);
        //console.table(rows[0]);
        result(null,rows);
    }

    static async GetSomeLivros(result) {
        let query = "SELECT title, authors, publication_date FROM livro;";
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

    /**
     * Permite remover um livro 
     * @param {int} bookID Identificação de uma utilizador
     * @param {*} result Retorna um erro, caso ele exista
     */
    static async DeleteLivro(bookID,result) {
        let query = `DELETE FROM livro WHERE bookID = "${bookID}"`;
        const[rows,fields] =  await sql.execute(query);
        //console.table(rows[0]);
        result(null,rows);
    }

    /**
     * Adiciona um livro na base de dados
     * @param {*} title Titlo do livro
     * @param {*} authors Autor/es do livro
     * @param {*} average_rating Classificaçáo média do livro
     * @param {*} isbn Código único do livro
     * @param {*} num_pages Número de páginas
     * @param {*} publication_date Data de publicação 
     * @param {*} publisher Editora do livro
     * @param {*} result Livro adicionado
     */
    static async AddLivro(title, authors, average_rating, isbn, num_pages, publication_date, publisher, result) {
        const[rows,fields]= await sql.execute(`INSERT INTO livro (title, authors, average_rating, isbn, num_pages, publication_date, publisher)
        VALUES ("${title}","${authors}","${average_rating}","${isbn}","${num_pages}","${publication_date}","${publisher}")`);
        if (rows[0]){
            //console.log("error: ", rows[0][0]);
            result("Livro já existe", null);
        }else {
            //console.log("created user");
            result(null,rows);
        }
    }
}

module.exports = Livro;