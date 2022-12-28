const mysql = require('mysql');
const pool = mysql.createPool({

    database: 'mydb',
    host: 'libracodedb.mysql.database.azure.com',
    port: '3306',
    user: 'libracode',
    password: 'projeto123#',
    ssl: true,
    dialectOptions: {
       ssl: {
          require: true
       }
     }
});

let mydbDB = {};

mydbDB.all = () => {
    return new Promise((resolve, reject) => {
        pool.query('SELECT * FROM livro',(err, results) => {
            if(err) {
                return reject(err);
            }
            return resolve(results);
        });
    });
};

mydbDB.one = (bookID) => {
    return new Promise((resolve, reject) => {
        pool.query('SELECT * FROM livro WHERE bookID = ?', [bookID],(err, results) => {
            if(err) {
                return reject(err);
            }
            return resolve(results[0]);
        });
    });
};

module.exports = mydbDB;