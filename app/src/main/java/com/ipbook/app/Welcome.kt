package com.ipbook.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.DelicateCoroutinesApi
import java.io.File

class Welcome : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val login = findViewById<Button>(R.id.btnLogIn)
        val registo = findViewById<Button>(R.id.btnRegisto)

        login.setOnClickListener(){
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        registo.setOnClickListener(){
            val intent = Intent(this, Registo::class.java)
            startActivity(intent)
        }
    }
}
