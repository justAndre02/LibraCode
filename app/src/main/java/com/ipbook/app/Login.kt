package com.ipbook.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.gson.Gson
import com.ipbook.app.api.Api
import com.ipbook.app.model.User
import com.ipbook.app.util.Constant.baseUrl
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.regex.Pattern

class Login() : AppCompatActivity() {

    private lateinit var email : EditText

    private lateinit var password : EditText

    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button = findViewById(R.id.btnLogInOne)
        password = findViewById(R.id.etComponentOne)
        email = findViewById(R.id.etComponent)

        button.setOnClickListener{
            verifyUser { found ->
                if (found == 1){
                    val intent = Intent(this, Homescreen::class.java)
                    startActivity(intent)
                }
            }

        }

    }

    private fun verifyUser(callback: (Int) -> Unit) : Int{
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
        val api = retrofit.create(Api::class.java)

        var found : Int = 0

        val mycall:Call<List<User>> = api.getUsers()

        mycall.enqueue(object : Callback<List<User>?>{
            override fun onResponse(call: Call<List<User>?>, response: Response<List<User>?>){
                val users:List<User> = response.body()!!

                validateEmail()

                for (user in users){
                    if (user.email == email.text.toString() && user.password == password.text.toString()
                        && validateEmail()){
                        found = 1
                        callback(found)
                        break
                    }
                    if(user.password != password.text.toString()){password.error = "Palavra-passe incorreta"}
                    if(user.email != email.text.toString() && validateEmail()){email.error = "Email incorreto"}
                }
            }
            override fun onFailure(call: Call<List<User>?>, t: Throwable) {
                println("Error")
            }
        })
        return found
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
}