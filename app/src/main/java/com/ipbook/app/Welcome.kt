package com.ipbook.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.gson.JsonObject
import com.ipbook.app.util.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class Welcome : AppCompatActivity() {
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