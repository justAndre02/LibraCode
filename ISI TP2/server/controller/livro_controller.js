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

/**
 * Remove um livro pelo seu nome
 * @param {*} req 
 * @param {*} res 
 * @param {*} next 
 * @returns data[0]
 */
exports.DeleteLivro_delete = async (req, res, next) => {
  try {
    if(!req.params) return res.status(404).json({message:"bad request"});
    const{bookID} = req.params;
    await Livro.DeleteLivro(bookID,(err, data) => {
        if(err){
          res.status(500).json({message: err.message || "Não foi possivel remover o livro"});
        }
      res.status(404).json({ message: "Livro removido com sucesso" });
      res.status(200).json(data[0]);
    });
  } catch (error) {
    console.log(error);
    next(error);
  }
};

/**
 * Adiciona um livro
 * @param {*} req 
 * @param {*} res 
 * @param {*} next 
 * @returns Livro adicionado
 */
exports.AddLivro_post = async (req, res,next) => {
  try {
    // Validar request
    if (!req.body)
      res.status(400).json({message: "Conteudo nao pode estar vazio!"});

    // verificar se os campos foram preeenchidos
    if((req.body.title === "") || (req.body.authors === "") || (req.body.average_rating === "") || (req.body.isbn === "") || (req.body.num_pages === "") || (req.body.publication_date === ""  || (req.body.publisher === ""))) 
      res.status(400).json({Message: "Campos Não preenchidos"});

    const { title, authors, average_rating, isbn, num_pages, publication_date, publisher} = req.body;

    await Livro.GetLivroISBN(isbn,async (err, data) => {
      if (err){
        res.status(500).json({message: "Ocorreu algum erro ao criar o Utilizador"});
      }
      if(data.length > 0){
        return res.status(200).json({"message": "Este Livro já existe"}); 
      }
      else{
        // salvar Livro na base de dados
        await Livro.AddLivro(title, authors, average_rating, isbn, num_pages, publication_date, publisher,(err, data) => {
          if (err){
            res.status(500).json({message: "Ocorreu algum erro ao adicionar o livro"});
          }else{
            res.status(200).json({message: "Livro adicionado com sucesso"});
          }
        });
      }
    });
  } catch (error) {
    console.log(error);
    next(error);
  }
};
