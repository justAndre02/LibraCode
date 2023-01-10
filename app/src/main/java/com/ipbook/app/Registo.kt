package com.ipbook.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Registo : AppCompatActivity() {
    private val BASE_URL = "https://isi-pa.onrender.com/"

    private lateinit var nome : EditText

    private lateinit var email : EditText

    private lateinit var password : EditText

    private lateinit var next : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registo)

        email = findViewById(R.id.etComponentOne)

        nome = findViewById(R.id.etComponent)

        password = findViewById(R.id.etComponentTwo)

        next = findViewById(R.id.btnNext)


    }

}