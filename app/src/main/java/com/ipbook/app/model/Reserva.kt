package com.ipbook.app.model

// Utilizada para o Post de fazer um empréstimo
data class Reserva(
    val data : String,
    val data_devolucao : String,
    val Livro_id : Int
)

// Utilizada para o Get de todas as reservas do utilizador
data class DadosReserva(
    val eid : Int,
    val data : String,
    val data_devolucao: String,
    val Livro_id: Int,
    val Utilizador_id : Int
)
