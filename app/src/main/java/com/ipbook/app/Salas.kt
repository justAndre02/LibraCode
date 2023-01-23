package com.ipbook.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Salas : AppCompatActivity() {

    private lateinit var home : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salas_de_estudo)

        home = findViewById(R.id.btnHome)

        home.setOnClickListener{
            val intent = Intent(this, Homescreen::class.java)
        }
    }
}