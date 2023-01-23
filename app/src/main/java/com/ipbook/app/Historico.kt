package com.ipbook.app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ipbook.app.api.Api
import com.ipbook.app.model.DadosReserva
import com.ipbook.app.recyclerview.MyAdapterReservas
import com.ipbook.app.util.Constant
import okhttp3.internal.notify
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Historico : AppCompatActivity() {

    lateinit var layoutManager: LinearLayoutManager

    lateinit var adapter : MyAdapterReservas

    lateinit var mycall : Call<MutableList<DadosReserva>>

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservas)

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.baseUrl)
            .build()

        val api = retrofit.create(Api::class.java)

        mycall = api.getEmprestimoUser(Login.Data.id)

        recyclerView = findViewById(R.id.listareservas)

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        getEmprestimoList()
    }

    private fun getEmprestimoList() {
        recyclerView = findViewById(R.id.listareservas)
        mycall.enqueue(object : Callback<MutableList<DadosReserva>?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<MutableList<DadosReserva>?>,
                response: Response<MutableList<DadosReserva>?>
            ) {
                adapter = MyAdapterReservas(baseContext, response.body() as MutableList<DadosReserva>)
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<MutableList<DadosReserva>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}