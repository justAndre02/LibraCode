package com.ipbook.app.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.ipbook.app.Livros
import com.ipbook.app.Login
import com.ipbook.app.R
import com.ipbook.app.api.Api
import com.ipbook.app.model.Book
import com.ipbook.app.model.Reserva
import com.ipbook.app.util.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDate
import java.time.format.DateTimeFormatter


// Criação do Adapter para a Recycler View dos livros
class MyAdapter(private val context: Context, private val booklist : MutableList<Book>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false)
        return MyViewHolder(itemView)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bookID.text = "ID: " + booklist[position].bookID.toString()
        holder.bookname.text = "Nome: " + booklist[position].title
        holder.bookauthor.text = "Autor: " + booklist[position].authors
        holder.bookyear.text = "Ano: " + booklist[position].publication_date

        holder.btnReserva.setOnClickListener{
            val book = booklist[position]
            reserveBook(book){}
        }
    }

    override fun getItemCount(): Int {
        return booklist.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var bookID : TextView
        var bookname : TextView
        var bookauthor : TextView
        var bookyear : TextView
        var btnReserva: Button

        init {
            bookID = itemView.findViewById(R.id.bookID)
            bookname = itemView.findViewById(R.id.bookname)
            bookauthor = itemView.findViewById(R.id.bookauthor)
            bookyear = itemView.findViewById(R.id.bookyear)
            btnReserva = itemView.findViewById(R.id.btnReserva)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SimpleDateFormat")
    private fun reserveBook(book: Book, callback: (Int) -> Unit) {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.baseUrl)
            .build()

        var code : Int

        val api = retrofit.create(Api::class.java)

        val currentDate = LocalDate.now()
        val futureDate = currentDate.plusDays(6)
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val futureDateFormatted = futureDate.format(formatter)
        val currentDateFormatted = currentDate.format(formatter)

        val reserva = Reserva(
            currentDateFormatted.toString(),
            futureDateFormatted.toString(),
            book.bookID
        )

        val mycall = api.doemprestimo(Login.Data.id, reserva)

        mycall.enqueue(object : Callback<Reserva?> {
            override fun onResponse(call: Call<Reserva?>, response: Response<Reserva?>) {
                code = response.code()
                callback(code)
            }

            override fun onFailure(call: Call<Reserva?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

}