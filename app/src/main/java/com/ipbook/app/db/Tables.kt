package com.ipbook.app.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ipbook.app.model.UpdateUserPassword

// Class com as tabelas da base de dados
class Tables {

    // Informação dos detalhes da tabela "users"
    @Entity(tableName = "users")
    data class Users(
        @PrimaryKey(autoGenerate = true) val id : Int = 0,
        @ColumnInfo("nome") val nome : String,
        @ColumnInfo("email") val email : String,
        @ColumnInfo("password") val password: String,
        @ColumnInfo("nif") val nif: Int
    )
}