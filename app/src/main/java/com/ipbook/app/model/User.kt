package com.ipbook.app.model

// Aqui encontram-se todas as classes que são chamadas quando se realiza alguma chamada à API que envolva dados de users

// Fazer o login do utilizador
data class UserLogin (
    var email: String,
    var password: String)

// Registar um utilizador
data class SendUser(
    var nome : String,
    var email : String,
    var password: String,
    var nif: Int?,
    var TipoUtilizador_id: Int)

// Receber todos os utilizadores
data class AllUsers(
    var id : Int,
    var nome : String,
    var email : String,
    var password: String,
    var nif: Int?,
    var TipoUtilizador_id: Int)

// Update no nome do utilizador
data class UpdateUserName(
    var id: Int,
    var nome : String
)

// Update na password do utilizador
data class UpdateUserPassword(
    var id: Int,
    var password: String
)

