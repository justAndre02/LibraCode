package com.ipbook.app.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ipbook.app.R
import com.ipbook.app.model.DadosReserva

// Adapter para a recycler view das reservas de um utilizador
class MyAdapterReservas (private val context: Context, private val dadosReservalist: MutableList<DadosReserva>) : RecyclerView.Adapter<MyAdapterReservas.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.layout_itemreserva, parent, false)
        return MyViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.setBackgroundResource(R.drawable.item_border)

        holder.eid.text = "Reserva ID: " + dadosReservalist[position].eid.toString()
        holder.bid.text = "Livro ID: " + dadosReservalist[position].Livro_id.toString()
        holder.data.text = "Data: " + dadosReservalist[position].data
        holder.data_devolucao.text = "Data Devolução: " + dadosReservalist[position].data_devolucao
    }

    override fun getItemCount(): Int {
        return dadosReservalist.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var eid : TextView
        var data : TextView
        var data_devolucao : TextView
        var bid : TextView

        init {
            eid = itemView.findViewById(R.id.IDreserva)
            data = itemView.findViewById(R.id.data)
            data_devolucao = itemView.findViewById(R.id.dataDevolver)
            bid = itemView.findViewById(R.id.IDbook)
        }
    }


}