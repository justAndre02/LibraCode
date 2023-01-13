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
import com.ipbook.app.model.SendUser
import com.ipbook.app.util.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Registo : AppCompatActivity() {

    private lateinit var nome: EditText

    private lateinit var email: EditText

    private lateinit var password: EditText

    private lateinit var next: Button

    private lateinit var nif : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registo)

        email = findViewById(R.id.etComponentOne)

        nome = findViewById(R.id.etComponent)

        password = findViewById(R.id.etComponentTwo)

        nif = findViewById(R.id.etComponentThree)

        next = findViewById(R.id.btnNext)

        next.setOnClickListener{
            if(validateEmail()){
                registerUser{ validate ->
                    if (validate == 200){
                        openDialog()
                    }
                }
            }
        }
    }

    @SuppressLint("InflateParams", "SetTextI18n")
    private fun openDialog(){
        val builder = AlertDialog.Builder(this)
        val inflater = LayoutInflater.from(this)
        val dialogLayout = inflater.inflate(R.layout.dialog_login, null, false)

        with(builder){
            setView(dialogLayout)
            setTitle("Sucesso")
            val messageDialog = dialogLayout.findViewById<TextView>(R.id.text_error_message)
            messageDialog.text = "Utilizador criado com sucesso!"
            val buttonDialog = dialogLayout.findViewById<Button>(R.id.button_ok)
            val dialog = builder.show()
            buttonDialog.setOnClickListener{
                val intent = Intent(this@Registo, Welcome::class.java)
                startActivity(intent)
                dialog.dismiss()
            }
        }
    }

    private fun registerUser(callback: (Int) -> Unit) : Int {

        var validate = 0

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.baseUrl)
            .build()

        val api = retrofit.create(Api::class.java)

        val sendUser = SendUser(
            nome.text.toString(),
            email.text.toString(),
            password.text.toString(),
            nif.text.toString().toInt(),
            1
        )

        val myCall = api.sendUserData(sendUser)

        myCall.enqueue(object : Callback<SendUser?> {
            override fun onResponse(call: Call<SendUser?>, response: Response<SendUser?>) {
                println(response.code().toString())
                validate = response.code()
                callback(validate)
            }
            override fun onFailure(call: Call<SendUser?>, t: Throwable) {
                println("Erro")
            }
        })
        return validate
    }


    private fun validateEmail(): Boolean {
        val emailValidate = email.text.toString().trim()
        return if (emailValidate.isEmpty()) {
            email.error = "Please enter a email"
            false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailValidate).matches()) {
            email.error = "Wrong email format"
            false
        } else {
            true
        }
    }
}