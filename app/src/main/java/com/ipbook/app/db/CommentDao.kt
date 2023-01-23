package com.ipbook.app.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CommentDao {

    /* Interface dedicada à base de dados que foi implementada mas depois retirada
    *  Em baixo estão as querys utilizadas para obter, inserir e atualizar os dados da base de dados
    * */

    @Query("SELECT * FROM users")
    fun getAll(): List<Tables.Users>

    @Query("SELECT * FROM users WHERE id = :id")
    fun findbyemail(id : Int): Tables.Users

    @Insert
    fun insertAll(vararg user: Tables.Users)

    @Update
    fun updateBook(vararg user: Tables.Users)


}