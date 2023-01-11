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
    if((req.body.nome === "") || (req.body.email === "") || (req.body.password === "") || (req.body.nif === "") || (req.body.TipoUtilizador_id === "")) {
      res.status(400).json({Message: "Campos Não preenchidos"});
    } 

    const { nome, email, password, nif, TipoUtilizador_id} = req.body;

    //verificar se existe utilizador com email ou nif igual
    await Utilizador.GetUtilizadorEmailNif(email,nif,async (err, data) => {
      if (err){
        res.status(500).json({message: "Ocorreu algum erro ao criar o Utilizador"});
      }
      if(data.length > 0){
        return res.status(400).json({"message": "Este Utilizador já existe"}); 
      }
      else{
        // salvar utilizador na base de dados
        await Utilizador.RegisterUtilizador(nome, email, password, nif, TipoUtilizador_id,(err, data) => {
          if (err){
            res.status(500).json({message: "Ocorreu algum erro ao criar o Utilizador"});
          }else{
            res.status(200).json({message: "Utilizador criado com sucesso"});
          }
        });
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
 * @returns Password atualizada com sucesso !
 */
exports.UpdateUtilizadorPassword_put = async (req, res,next) => {
  try {
    if(!req.params) return res.status(404).json({message:"bad request"});
    const{id} = req.params;
    if (!req.body)
      res.status(400).json({message: "Conteudo nao pode estar vazio!"});
    if (req.body.password != "")
      await Utilizador.UpdateUtilizadorPassword(req.body.password,id, (err1, data1) => {
        if (err1)
          res.status(500).json({ message: err1.message || "Ocorreu algum erro ao atualizar o conteudo"});
      });
    res.status(200).json({message: "Password atualizada com sucesso !"});  
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
      if(data.length === 0)
        {
          res.status(200).json({message: "Este utilizador não existe"});
        }
      else{
        res.status(200).json(data[0]);
      }
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
    await Utilizador.DeleteUtilizador(id,(err, data) => {
      if(err)
        {
          res.status(500).json({message: err.message || "Não foi possivel eliminar o utilizador"});
        }  
      res.status(404).json({ message: "Utilizador eliminado com sucesso" });
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
 * @returns Login efetuado com sucesso!
 */
exports.GetLogin_post = async (req, res,next) => {
  try {
    if(!req.params) return res.status(404).json({message:"bad request"});

    if ((req.body.email === "") || (req.body.password === ""))
      res.status(400).json({ Message: "Conteudo nao pode estar vazio" });

    const { email, password } = req.body;

    await Utilizador.GetToken(async (err, data) => {
      if(err)
      {
          res.status(500).json({message: err.message || "Não foi possivel logar o utilizador"});
      }
      if(data.length === 0)
      {
        await Utilizador.GetLogin(email, password, async (err1, data) => {
          if (err1)
            res.status(500).json({ message: err1.message || "Dados Incorretos"});
          else {
            results = JSON.parse(JSON.stringify(data[0]));
            console.log(results[0].email,results[0].id, results[0].password);
            if ((results[0].email == email) && (results[0].password == password)) {
              let token = jwt.sign(results[0],'secret'); 
              await Utilizador.RegisterToken(token,(err, data) => {
                if(err)
                  {
                    res.status(500).json({message: err.message || "Não foi possivel logar o utilizador"});
                  }  
                res.status(200).json({token,UserEmail:results[0].email,UserId:results[0].id});
              });  
            }
            else res.status(404).json({ message: "Utilizador não encontrado" });
          }
        });
      }
      else
      {
        return res.status(500).json({message: "Já está logado"});
      }
    });  
  } catch (error) {
    console.log(error);
    next(error);
  }
};

exports.signupValidation = async(req,res,next) => {
  try{
    if(
      !req.headers.authorization ||
      !req.headers.authorization.startsWith('Bearer') ||
      !req.headers.authorization.split(' ')[1]
    ){
      return res.status(422).json({
      message: "Insire o token",
    });
    }
      const theToken = req.headers.authorization.split(' ')[1];
      const decoded = jwt.verify(theToken, 'secret');
      await Utilizador.GetUtilizadorInfo(decoded.id,(err, data) => {
        if(err)
          {
            res.status(500).json({message: err.message || "Ocorreu um erro a obter informacao sobre o utilizador"});
          }  
          return res.send({ error: false, data: data[0], message: 'Utilizador Encontrado.' });
      });
  }
  catch(error) {
    console.log(error);
    next(error);
  }
};

exports.Logout_delete = async (req, res,next) => {
  try {
    if(!req.params) return res.status(404).json({message:"bad request"});

    const idtoken = '1';

    await Utilizador.GetToken(async(err,data) => {
      if(err) {
        res.status(500).json({message: "Ocorreu algum erro para obter os dados dos utilizadores"});
      }
      if(data.length === 0)
      {
        return res.status(200).json({message: "Nenhum utilizador logado"})
      }else {
        await Utilizador.EliminarToken(idtoken,(err1, data) => {
          if (err1)
            res.status(500).json({message: "Ocorreu algum erro para obter os dados dos utilizadores"});
          else{ 
            res.status(200).json({"message": "Sessão terminada"});
          }
        });
      }
    })
    
  } catch (error) {
    console.log(error);
    next(error);
  }
};

exports.GetToken_get = async (req, res,next) => {
  try {
    await Utilizador.GetToken((err, data) => {
      if (err)
        res.status(500).json({message: "Ocorreu algum erro para obter os dados dos utilizadores"});
      if(data.length === 0) res.status(200).json({message: "Nenhum token ativo"});
      else res.status(200).json(data);
    });
  } catch (error) {
    console.log(error);
    next(error);
  }
};