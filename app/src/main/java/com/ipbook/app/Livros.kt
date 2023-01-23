package com.ipbook.app

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ipbook.app.api.Api
import com.ipbook.app.recyclerview.MyAdapter
import com.ipbook.app.model.Book
import com.ipbook.app.util.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Livros : AppCompatActivity() {

    lateinit var layoutManager: LinearLayoutManager

    lateinit var adapter: MyAdapter

    lateinit var mycall : Call<MutableList<Book>>

    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_requisicao)
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.baseUrl)
            .build()

        val api = retrofit.create(Api::class.java)

        mycall = api.getLivros()

        recyclerView = findViewById(R.id.listalivros)

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        getBooksList()

    }

    private fun getBooksList() {
        recyclerView = findViewById(R.id.listalivros)
        mycall.enqueue(object : Callback<MutableList<Book>?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<MutableList<Book>?>,
                response: Response<MutableList<Book>?>
            ) {
                adapter = MyAdapter(baseContext, response.body() as MutableList<Book>)
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<MutableList<Book>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    @SuppressLint("InflateParams", "SetTextI18n")
    fun openDialog(context: Context){
        val builder = AlertDialog.Builder(context)
        val inflater = LayoutInflater.from(context)
        val dialogLayout = inflater.inflate(R.layout.dialog_login, null, false)

        with(builder){
            setView(dialogLayout)
            setTitle("Sucesso")
            val messageDialog = dialogLayout.findViewById<TextView>(R.id.text_error_message)
            messageDialog.text = "Reserva realizada com sucesso!"
            val buttonDialog = dialogLayout.findViewById<Button>(R.id.button_ok)
            val dialog = builder.show()
            buttonDialog.setOnClickListener{
                dialog.dismiss()
            }
        }
    }
}