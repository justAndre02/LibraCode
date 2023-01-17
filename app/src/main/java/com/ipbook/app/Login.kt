package com.ipbook.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.gson.JsonObject
import com.ipbook.app.api.ApiInterface
import com.ipbook.app.data.UserDataItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.regex.Pattern
import javax.security.auth.callback.Callback



class Login : AppCompatActivity() {

    private val BASE_URL = "https://isi-pa.onrender.com/"

    private lateinit var email : EditText

    private lateinit var password : EditText

    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        button = findViewById<Button>(R.id.btnLogInOne)
        password = findViewById<EditText>(R.id.etComponentOne)
        email = findViewById<EditText>(R.id.etComponent)

        button.setOnClickListener(){
            verifyUser()
        }
    }


    private fun verifyUser(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getUserData()

        retrofitData.enqueue(object : retrofit2.Callback<List<UserDataItem>?> {
            override fun onResponse(call: Call<List<UserDataItem>?>, response: Response<List<UserDataItem>?>){
                val responseBody = response.body()!!
                validateEmail()
                validatePassword()
                for (UserData in responseBody){
                    if (UserData.email == email.text.toString()){
                        email.error = "Email em uso!"
                        break;
                    }
                    if (!validateEmail() || !validatePassword()){
                        break;
                    }
                }
            }
            override fun onFailure(call: Call<List<UserDataItem>?>, t: Throwable) {
                println("Falhou!")
            }
        })
    }

    private fun validateEmail() : Boolean {
        val emailValidate = email.text.toString().trim()
        return if(emailValidate.isEmpty()){
            email.error = "Please enter a email"
            false
        }else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(emailValidate).matches()){
            email.error = "Wrong email format"
            false
        } else{
            true
        }
    }

    private fun validatePassword() : Boolean {
        val passwordValidate = password.text.toString().trim()
        val passwordREGEX = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=\\S+\$).{6,}")
        return if(passwordValidate.isEmpty()){
            password.error = "Please enter a password"
            false
        }else if(!passwordREGEX.matcher(passwordValidate).matches()){
            password.error = "Password not valid"
            false
        }
        else{
            true
        }
    }
}