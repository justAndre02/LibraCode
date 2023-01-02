const Livro = require("../db/livro")

/**
 * Chama todos os livros e lista toda a sua informação
 * @param {*} req 
 * @param {*} res 
 * @param {*} next 
 * @returns data
 */
exports.GetAllLivros_get = async (req, res,next) => {
    try {
      await Livro.GetAllLivros((err, data) => {
        if (err)
          res.status(500).json({
            message:
              err.message || "Ocorreu algum erro para obter os dados dos livros"
          });
        else res.status(200).json(data);
      });
    } catch (error) {
      console.log(error);
      next(error);
    }
};

/**
 * Chama um livro pelo seu id
 * @param {*} req 
 * @param {*} res 
 * @param {*} next 
 * @returns data[0]
 */
exports.GetLivroInfo_get = async (req, res,next) => {
    try {
      if(!req.params) return res.status(404).json({message:"bad request"});
      const{bookID} = req.params;
      await Livro.GetLivroInfo(bookID,(err, data) => {
        if(err)
          {
            res.status(500).json({message: err.message || "Ocorreu um erro a obter informacao sobre o livro"});
          }  
        res.status(200).json(data[0]);
      });  
    } catch (error) {
      console.log(error);
      next(error);
    }
};