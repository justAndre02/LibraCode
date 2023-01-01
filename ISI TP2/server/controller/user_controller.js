const Utilizador = require("../db/user");
var jwt = require('jsonwebtoken');

/**
 * Encarregue de registar um Utilizador
 * @param {*} req 
 * @param {*} res 
 * @param {*} next 
 * @returns Utilizador criado com sucesso!
 */
exports.RegisterUtilizador_post = async (req, res,next) => {
  try {
    // Validar request
    if (!req.body)
      res.status(400).json({message: "Conteudo nao pode estar vazio!"});

    // verificar se os campos foram preeenchidos
    if((req.body.nome === "") || (req.body.email === "") || (req.body.password === "") || (req.body.nif === "")| (req.body.TipoUtilizador_id === "")) 
      res.status(400).json({Message: "Campos Não preenchidos"});

    const { nome, email, password, nif, TipoUtilizador_id} = req.body;

    // salvar utilizador na base de dados
    await Utilizador.RegisterUtilizador(nome, email, password, nif,TipoUtilizador_id,(err, data) => {
      if (err){
        res.status(500).json({message: "Ocorreu algum erro ao criar o Utilizador"});
      }else{
        res.status(200).json({message: "Utilizador criado com sucesso"});
      }
    });
  } catch (error) {
    console.log(error);
    next(error);
  }
};

/**
 * Chama todos os utilizadores e lista toda a sua informação
 * @param {*} req 
 * @param {*} res 
 * @param {*} next 
 * @returns data
 */
exports.GetUtilizadorAllDetails_get = async (req, res,next) => {
  try {
    await Utilizador.GetUtilizadorAllDetails((err, data) => {
      if (err)
        res.status(500).json({
          message:
            err.message || "Ocorreu algum erro para obter os dados dos utilizadores"
        });
      else res.status(200).json(data);
    });
  } catch (error) {
    console.log(error);
    next(error);
  }
};

/**
 * 
 * @param {*} req 
 * @param {*} res 
 * @param {*} next 
 * @returns Utilizador atualizado com sucesso!
 */
exports.UpdateUtilizador_put = async (req, res,next) => {
  try {
    if(!req.params) return res.status(404).json({message:"bad request"});
    const{id} = req.params;
    if (!req.body)
      res.status(400).json({message: "Conteudo nao pode estar vazio!"});
    if (req.body.nome != "")
      await Utilizador.UpdateUtilizadorNome(req.body.nome,id, (err1, data1) => {
        if (err1)
          res.status(500).json({ message: err1.message || "Ocorreu algum erro ao atualizar o conteudo"});
      });
    res.status(200).json({message: "Utilizador atualizado com sucesso !"});  
  } catch (error) {
    console.log(error);
    next(error);
  }
};

/**
 * 
 * @param {*} req 
 * @param {*} res 
 * @param {*} next 
 * @returns data[0]
 */
exports.GetUtilizadorInfo_get = async (req, res,next) => {
  try {
    if(!req.params) return res.status(404).json({message:"bad request"});
    const{id} = req.params;
    await Utilizador.GetUtilizadorInfo(id,(err, data) => {
      if(err)
        {
          res.status(500).json({message: err.message || "Ocorreu um erro a obter informacao sobre o utilizador"});
        }  
      res.status(200).json(data[0]);
    });  
  } catch (error) {
    console.log(error);
    next(error);
  }
};

/**
 * 
 * @param {*} req 
 * @param {*} res 
 * @param {*} next 
 * @returns Utilizador removido com sucesso!
 */
exports.DeleteUtilizador_delete = async (req, res,next) => {
  try {
    if(!req.params) return res.status(404).json({message:"bad request"});
    const{id} = req.params;
    if (!req.body)
      res.status(400).json({message: "Conteudo nao pode estar vazio!"});
    if (req.body.nome != "")
      await Utilizador.DeleteUtilizador(req.body.nome,id, (err1, data1) => {
        if (err1)
          res.status(500).json({ message: err1.message || "Ocorreu algum erro ao eliminar o conteudo"});
      });
    res.status(200).json({message: "Utilizador removido com sucesso !"});  
  } catch (error) {
    console.log(error);
    next(error);
  }
};

/**
 * 
 * @param {*} req 
 * @param {*} res 
 * @param {*} next 
 * @returns Login efetuado com sucesso!
 */
exports.GetLogin_post = async (req, res,next) => {
  try {
    if(!req.params) return res.status(404).json({message:"bad request"});
    const{id} = req.params;

    if ((req.body.email === "") || (req.body.password === ""))
      res.status(400).json({ Message: "Conteudo nao pode estar vazio" });

    const { email, password } = req.body;

      await Utilizador.GetLoginr(email, password, (err1, data) => {
        if (err1)
          res.status(500).json({ message: err1.message || "Erro ao efetuar o login"});
        else {
          results = JSON.parse(JSON.stringify(data[0]));
          console.log(results[0].email,results[0].id, results[0].password);
          if ((results[0].email == email) && (results[0].password == pass)) {
            let token = jwt.sign(results[0],'secret',{expiresIn:'1h'})
            res.status(200).json({token,UserEmail:results[0].email,UserId:results[0].id});
          }
          else res.status(404).json({ message: "Utilizador não encontrado" });
        }
      });
  } catch (error) {
    console.log(error);
    next(error);
  }
};