package com.ipbook.app.model

import androidx.room.ColumnInfo

// Utilizada para receber os dados dos livros
// É chamada quando o método Get dos livros é utilizado
data class Book (
    val bookID : Int,
    val title : String,
    val authors : String,
    val average_rating: String,
    val isbn : String,
    val num_pages : String,
    val publication_date : String,
    val publisher : String
)