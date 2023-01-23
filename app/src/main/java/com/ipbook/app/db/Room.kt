package com.ipbook.app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Class responsável pela criação da base de dados
@Database(entities = arrayOf(Tables.Users::class), version = 1)
abstract class MyDatabase : RoomDatabase(){
    abstract fun commentDao() : CommentDao

    companion object {
        @Volatile private var instance: MyDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context)= instance?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context, MyDatabase::class.java, "ipbook.db").build()
    }
}