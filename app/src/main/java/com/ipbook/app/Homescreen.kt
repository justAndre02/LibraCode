package com.ipbook.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import com.ipbook.app.api.Api
import com.ipbook.app.util.Constant
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Homescreen : AppCompatActivity() {

    private lateinit var exit : ImageView

    private lateinit var perfil : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homescreen)

        exit = findViewById(R.id.button)

        perfil = findViewById(R.id.linearButton)

        exit.setOnClickListener{
            registerUser { validate ->
                if (validate == 200){
                    val intent = Intent(this, Welcome::class.java)
                    startActivity(intent)
                }
            }
        }

        perfil.setOnClickListener{
            val intent = Intent(this, Perfil::class.java)
            startActivity(intent)
        }
    }

    private fun registerUser(callback: (Int) -> Unit) : Int {

        var validate = 0

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.baseUrl)
            .build()

        val api = retrofit.create(Api::class.java)


        val myCall = api.deleteToken()

        myCall.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {
                validate = response.code()
                println(validate)
                callback(validate)
            }

            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                println("Erro")
            }
        })

        return validate
    }
}