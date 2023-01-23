package com.ipbook.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView

class Recomendados : AppCompatActivity() {

    private lateinit var back : ImageButton

    private lateinit var home : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livros_recomendados)

        back = findViewById(R.id.btnArrowleft)

        home = findViewById(R.id.btnHome)

        back.setOnClickListener{
            val intent = Intent(this, Disciplinas::class.java)
            startActivity(intent)
        }

        home.setOnClickListener{
            val intent = Intent(this, Homescreen::class.java)
            startActivity(intent)
        }
    }
}