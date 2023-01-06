const Emprestimo = require("../db/emprestimo");
const Utilizador = require("../db/user");
const Livro = require("../db/livro")

exports.MakeEmprestimo_post = async (req,res,next)=>{
    try {
        if (!req.body)
            res.json({message: "Conteúdo não pode estar vazio!"});

        // verificar se os campos foram preeenchidos
        if((req.body.date === "") || (req.body.data_devolucao === "") || (req.body.Livro_id === ""))
            res.json({message: "Campos Não preenchidos"});
    
        const { data, data_devolucao, Livro_id} = req.body;

        if(!req.params) return res.status(404).json({message:"bad request"});
        const{Utilizador_id} = req.params;

        await Utilizador.GetUtilizadorInfo(Utilizador_id,async (err,date) => {
            if (err)
                res.status(500).json({ message: err.message || "Ocorreu algum erro ao fazer a requisição" });
            if(date.length === 0){
                return res.status(500).json({ message: "O Utilizador que inseriu não existe" });
            }
            else{
                await Livro.GetLivroInfo(Livro_id,async (err,date) => {
                    if (err)
                        res.status(500).json({ message: err.message || "Ocorreu algum erro ao fazer a requisição" });
                    if(date.length === 0){
                        return res.status(500).json({ message: "O Livro que inseriu não existe" });
                    }
                    else{
                        await Emprestimo.MakeEmprestimo(data, data_devolucao, Utilizador_id, Livro_id, (err,data)=>{
                            if (err)
                                res.status(500).json({ message: err.message || "Ocorreu algum erro ao fazer a requisição" });
                            else 
                                res.status(200).json({message:"Requisição feita com Sucesso"});
                        });
                    }
                });
            }

        });
    } catch (error) {
        console.log(error);
        next(error);
    }
};

exports.CancelEmprestimo_post = async (req,res, next)=>{
    try {
        if (!req.body)
            res.status(400).json({message: "Conteudo nao pode estar vazio!"});

        // verificar se os campos foram preeenchidos
        if(req.body.eid === "")
            res.status(400).json({Message: "Campos Não preenchidos"});
    
        const { eid } = req.body;

        if(!req.params) return res.status(404).json({message:"bad request"});
        const{Utilizador_id} = req.params;

        await Emprestimo.CancelEmprestimo(Utilizador_id,eid,(err,data)=>{
            if (err)
                res.status(500).json({ message: err.message || "Ocorreu algum erro ao cancelar a requisição" });
            else 
                res.status(200).json({message:"Requsição cancelada!"});
        });
    } catch (error) {
        console.log(error);
        next(error);
    }
};

exports.EntregaEmprestimo_post = async (req,res, next)=>{
    try {
        if (!req.body)
            res.status(400).json({message: "Conteudo nao pode estar vazio!"});

        // verificar se os campos foram preeenchidos
        if(req.body.eid === "")
            res.status(400).json({Message: "Campos Não preenchidos"});
    
        const { eid } = req.body;

        if(!req.params) return res.status(404).json({message:"bad request"});
        const{Utilizador_id} = req.params;

        await Emprestimo.EntregaEmprestimo(Utilizador_id,eid,(err,data)=>{
            if (err)
                res.status(500).json({ message: err.message || "Ocorreu algum erro ao devolver a requisição" });
            else 
                res.status(200).json({message:"Requsição entregue!"});
        });
    } catch (error) {
        console.log(error);
        next(error);
    }
};

exports.GetEmprestimoAll_get = async (req, res,next) => {
    try {
      await Emprestimo.GetEmprestimoAll((err, data) => {
        if (err)
          res.status(500).json({
            message:
              err.message || "Ocorreu algum erro para obter os dados dos emprestimos"
          });
        else res.status(200).json(data);
      });
    } catch (error) {
      console.log(error);
      next(error);
    }
};