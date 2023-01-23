package com.ipbook.app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ipbook.app.api.Api
import com.ipbook.app.model.UpdateUserName
import com.ipbook.app.model.UpdateUserPassword
import com.ipbook.app.util.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Perfil : AppCompatActivity() {

    private lateinit var salvar : Button

    private lateinit var novoNome : EditText

    private lateinit var password: EditText

    private lateinit var password2 : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        val nome = findViewById<TextView>(R.id.txtname)
        nome.text = Login.Data.nome

        var helper = 0

        novoNome = findViewById(R.id.etNovoNome)

        password = findViewById(R.id.etComponent)

        password2 = findViewById(R.id.etComponentOne)

        salvar = findViewById(R.id.btnSalvarAlteracoes)

        salvar.setOnClickListener{
            if (novoNome.text.toString() != ""){
                if (password.text.toString() == password2.text.toString() && password.text.toString() != " "){
                    updatePassword {  }
                    updateProfile {  }
                    Login.Data.nome = novoNome.text.toString()
                    val intent = Intent(this, Homescreen::class.java)
                    startActivity(intent)
                }
                else{
                    updateProfile {  }
                    Login.Data.nome = novoNome.text.toString()
                    val intent = Intent(this, Homescreen::class.java)
                    startActivity(intent)
                }
            }
            else if(password.text.toString() == password2.text.toString() && password.text.toString() != " "){
                updatePassword {  }
                val intent = Intent(this, Homescreen::class.java)
                startActivity(intent)
            }
        }
    }


    private fun updateProfile(callback : (Int) -> Unit){
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.baseUrl)
            .build()

        val api = retrofit.create(Api::class.java)

        var found: Int

        val updateUser = UpdateUserName(
            Login.Data.id,
            novoNome.text.toString()
        )

        if (novoNome.text.toString() != ""){
            val mycall = api.updateName(Login.Data.id, updateUser)

            mycall.enqueue(object : Callback<UpdateUserName?> {
                override fun onResponse(call: Call<UpdateUserName?>, response: Response<UpdateUserName?>) {
                    found = response.code()
                    callback(found)
                    println(response.code())
                }

                override fun onFailure(call: Call<UpdateUserName?>, t: Throwable) {
                    println("Erro")
                }
            })
        }
    }

    private fun updatePassword(callback: (Int) -> Unit){
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.baseUrl)
            .build()

        val api = retrofit.create(Api::class.java)

        var foundP: Int

        val updateUserPassword = UpdateUserPassword(
            Login.Data.id,
            password.text.toString()
        )
        if(password.text != null && password2.text != null && password2.text.toString() == password.text.toString()){
            val myCall = api.updatePassword(Login.Data.id, updateUserPassword)

            myCall.enqueue(object : Callback<UpdateUserPassword?> {
                override fun onResponse(call: Call<UpdateUserPassword?>, response: Response<UpdateUserPassword?>){
                    foundP = response.code()
                    callback(foundP)
                    println(response.code())
                }

                override fun onFailure(call: Call<UpdateUserPassword?>, t: Throwable) {
                    println("Erro")
                }
            })
        }
        else if(password2.text.toString() != password.text.toString() && password2.text.toString() != "" && password.text.toString() != ""){
            openDialog()
        }
        else if(password2.text.toString() == "" && password.text.toString() != ""){
            password2.error = "Insira a password"
        }
    }

    @SuppressLint("InflateParams", "SetTextI18n")
    private fun openDialog(){
        val builder = AlertDialog.Builder(this)
        val inflater = LayoutInflater.from(this)
        val dialogLayout = inflater.inflate(R.layout.dialog_login, null, false)

        with(builder){
            setView(dialogLayout)
            setTitle("Erro")
            val messageDialog = dialogLayout.findViewById<TextView>(R.id.text_error_message)
            messageDialog.text = "Passwords não coincidem!"
            val buttonDialog = dialogLayout.findViewById<Button>(R.id.button_ok)
            val dialog = builder.show()
            buttonDialog.setOnClickListener{
                dialog.dismiss()
            }
        }
    }

}