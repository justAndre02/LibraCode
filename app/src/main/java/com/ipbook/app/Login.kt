package com.ipbook.app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.ipbook.app.api.Api
import com.ipbook.app.model.AllUsers
import com.ipbook.app.model.UserLogin
import com.ipbook.app.util.Constant.baseUrl
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class Login : AppCompatActivity() {

    private lateinit var email : EditText

    private lateinit var password : EditText

    private lateinit var button : Button

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button = findViewById(R.id.btnLogInOne)
        password = findViewById(R.id.etComponentOne)
        email = findViewById(R.id.etComponent)

        button.setOnClickListener{
            verifyUser { found ->
                if (found == 200){
                    val intent = Intent(this, Homescreen::class.java)
                    saveName{nome ->
                        if(nome != ""){
                            Data.nome = nome
                            intent.putExtra("nome", nome)
                            println(nome)
                        }
                    }
                    startActivity(intent)
                }
                else if(found == 404){
                    openDialog()
                }
            }

        }

    }

    /*
    *  Function used to open the Dialog window when the user insert data that is not in the API
    * */
    @SuppressLint("InflateParams", "SetTextI18n")
    private fun openDialog(){
        val builder = AlertDialog.Builder(this)
        val inflater = LayoutInflater.from(this)
        val dialogLayout = inflater.inflate(R.layout.dialog_login, null, false)

        with(builder){
            setView(dialogLayout)
            setTitle("Erro")
            val messageDialog = dialogLayout.findViewById<TextView>(R.id.text_error_message)
            messageDialog.text = "Dados inseridos incorretos!"
            val buttonDialog = dialogLayout.findViewById<Button>(R.id.button_ok)
            val dialog = builder.show()
            buttonDialog.setOnClickListener{
                dialog.dismiss()
            }
        }
    }

    /*
    * Function used to verify if the data inserted by the user is correct (email and password match)
    * To achieve that we used a POST method
    * */
    private fun verifyUser(callback: (Int) -> Unit) : Int{
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()

        val api = retrofit.create(Api::class.java)

        val userLogin = UserLogin(
            email.text.toString(),
            password.text.toString()
        )

        var found = 0

        val mycall = api.getUsers(userLogin)

        mycall.enqueue(object : Callback<UserLogin?> {
            override fun onResponse(call: Call<UserLogin?>, response: Response<UserLogin?>) {
                found = response.code()
                callback(found)
                println(response.code().toString())
            }

            override fun onFailure(call: Call<UserLogin?>, t: Throwable) {
                println("Error")
            }
        })

        return found
    }

    /*
    * Function used to get the name and the id of the user that logged in to update the User Account Page text
    * To achieve that we used a GET method
    * */
    private fun saveName(callback: (String) -> Unit) : String{
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()

        val api = retrofit.create(Api::class.java)

        // Make the API call
        val myCall = api.getAllUsers()

        var nome = ""

        myCall.enqueue(object : Callback<List<AllUsers>?> {
            override fun onResponse(call: Call<List<AllUsers>?>, response: Response<List<AllUsers>?>){
                val responseBody = response.body()!!
                for (AllUsers in responseBody){
                    if (AllUsers.email == email.text.toString()){
                        // Update the nome text
                        Data.id = AllUsers.id
                        nome = AllUsers.nome
                        callback(nome)
                    }
                }
            }

            override fun onFailure(call: Call<List<AllUsers>?>, t: Throwable) {
                println("Erro")
            }
        })
        return nome
    }

    /*
    * Variable the will hold the user name in all APP
    * */
    object Data{
        var nome : String = ""
        var id : Int = 0
    }

}