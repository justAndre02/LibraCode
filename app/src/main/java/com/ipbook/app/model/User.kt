package com.ipbook.app.model


class User (
    var id: Int,
    var nome: String,
    var email: String,
    var password: String,
    var nif: Int,
    var TipoUtilizador_id: Int)

data class SendUser(
    var nome : String,
    var email : String,
    var password: String,
    var nif: Int?,
    var TipoUtilizador_id: Int)