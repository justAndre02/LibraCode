const mysql = require('mysql2');

/**
* Faz a conexão com a base de dados MySQL
*/
const connection = mysql.createPool({
   connectionLimit : 10,
   password: 'projeto123#',
   user: 'libracode',
   database: 'mydb',
   host: 'libracodedb.mysql.database.azure.com',
   port: '3306'
});
  
module.exports = connection.promise();