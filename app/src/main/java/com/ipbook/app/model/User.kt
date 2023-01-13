package com.ipbook.app.model


data class UserLogin (
    var email: String,
    var password: String)

data class SendUser(
    var nome : String,
    var email : String,
    var password: String,
    var nif: Int?,
    var TipoUtilizador_id: Int)

data class AllUsers(
    var id : Int,
    var nome : String,
    var email : String,
    var password: String,
    var nif: Int?,
    var TipoUtilizador_id: Int)

data class UpdateUserName(
    var id: Int,
    var nome : String
)

data class UpdateUserPassword(
    var id: Int,
    var password: String
)

