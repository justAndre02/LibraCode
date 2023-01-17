package com.ipbook.app.data

data class UserDataItem(
    val id: Int,
    val nome: String,
    val email: String,
    val password: String,
    val nif: Int,
    val TipoUtilizador_id: Int
)