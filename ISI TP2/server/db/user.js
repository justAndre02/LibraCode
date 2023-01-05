const sql = require("./index");

class Utilizador 
{

    /**
     * Encarregue de registar um utilizador
     * @param {*} nome Devolve a nome criada 
     * @param {*} email Devolve o email criado
     * @param {*} password Devolve a password criada 
     * @param {*} nif Devolve a nif criada
     * @param {*} TipoUtilizador_id Devolve o id do tipo de utilizador criado 
     * @param {*} result Devolve um erro, caso este exista
     */
    static async RegisterUtilizador(nome, email, password, nif, TipoUtilizador_id, result) {
        const[rows,fields]= await sql.execute(`INSERT INTO utilizador (nome, email, password, nif, TipoUtilizador_id ) VALUES ("${nome}","${email}","${password}","${nif}","${TipoUtilizador_id}")`);
        if (rows[0]){
            //console.log("error: ", rows[0][0]);
            result("Utilizador já existe", null);
        }else {
            //console.log("created user");
            result(null,rows);
        }
    }

    /**
     * Chama uma query que vai listar todos os utilizador
     * @param  {*} result Devolve um erro, caso este exista
     */
    static async GetUtilizadorAllDetails(result) {
        let query = "SELECT * FROM utilizador";
        const[rows,fields] =  await sql.execute(query);
        //console.table(rows[0]);
        result(null,rows);
    }

    /**
     * Permite alterar o nome de um utilizador
     * @param {char} nome Nome já existante de um utilizador
     * @param {int} id Identificação de uma utilizador
     * @param {*} result Retorna um erro, caso ele exista
     */
    static async UpdateUtilizadorNome(nome,id,result) {
        let query = `UPDATE utilizador SET nome = "${nome}" WHERE id = "${id}"`;
        const[rows,fields] = await sql.execute(query);
        if (!rows[0]) {
            //console.log("error: ", rows[0][0]);
            result(rows[0], null);
        }else{
            result(null,null);
        }
    }

    /**
     * Permite alterar a password de um utilizador
     * @param {char} password Password já existante de um utilizador
     * @param {int} id Identificação de uma utilizador
     * @param {*} result Retorna um erro, caso ele exista
     */
    static async UpdateUtilizadorPassword(password,id,result) {
        let query = `UPDATE utilizador SET password = "${password}" WHERE id = "${id}"`;
        const[rows,fields] = await sql.execute(query);
        if (!rows[0]) {
            //console.log("error: ", rows[0][0]);
            result(rows[0], null);
        }else{
            result(null,null);
        }
    }

    /**
     * Apresenta toda a informação de um utilizador
     * @param {int} id Identificação de um utilizador
     * @param {*} result Dado a ser mudado
     */
    static async GetUtilizadorInfo(id, result) {
        let query = `SELECT * FROM utilizador WHERE id = "${id}" `;
        const[rows,fields] =  await sql.execute(query);
        //console.table(rows[0]);
        result(null,rows);
    }

    /**
     * Permite eliminar um utilizador
     * @param {int} id Identificação de uma utilizador
     * @param {*} result Retorna um erro, caso ele exista
     */
    static async DeleteUtilizador(id,result) {
        let query = `DELETE FROM utilizador WHERE id = "${id}"`;
        const[rows,fields] =  await sql.execute(query);
        //console.table(rows[0]);
        result(null,rows);
    }

    /**
     * Efetua o login de um utilizador
     * @param {*} email Email de um utilizador registado
     * @param {*} password Password de um utilizador registado
     * @param {*} result Retorna um erro, caso ele exista
     */
    static async GetLogin(email,password,result) {
        let query = `call LoginUser("${email}","${password}")`;
        const[rows,fields] = await sql.execute(query);
        if (!rows[0][0].id) {
            //console.log("error: ", rows[0][0]);
            result(rows[0][0], null);
        }else{
            result(null,rows);
        }
    }

    /**
     * Mostra um utilizador dado o seu NIF ou email
     * @param {*} email Email do utilizador
     * @param {*} nif NIF do utilizador
     * @param {*} result utilizadorcom email ou nif 
     */
    static async GetUtilizadorEmailNif(email,nif, result) {
        let query = `SELECT * FROM utilizador WHERE email LIKE "${email}" OR nif LIKE "${nif}"`;
        const[rows,fields] =  await sql.execute(query);
        //console.table(rows[0]);
        result(null,rows);
    }

    /**
     * Adiciona token na tabela token
     * @param {*} token Token
     */
    static async RegisterToken(token, result) {
        const[rows,fields]= await sql.execute(`INSERT INTO token (token) VALUES ("${token}")`);
        if (rows[0]){
            //console.log("error: ", rows[0][0]);
            result("Token já existe", null);
        }else {
            //console.log("created user");
            result(null,rows);
        }
    }

    /**
     * Mostra todos os tokens na tabela token
     * @param {*} token Token
     */
    static async GetToken(result) {
        let query = "SELECT * FROM token";
        const[rows,fields] =  await sql.execute(query);
        //console.table(rows[0]);
        result(null,rows);
    }

    /**
     * Eliminar tokens na tabela token
     */
    static async EliminarToken(id,result) {
        let query = `DELETE FROM token WHERE idtoken > "${id}"`;
        const[rows,fields] =  await sql.execute(query);
        //console.table(rows[0]);
        result(null,rows);
    }
}

  
module.exports = Utilizador;