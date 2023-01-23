package com.ipbook.app

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputLayout

class Disciplinas : AppCompatActivity() {

    val item = arrayOf<String>("Processamento de Linguagens", "Projeto Aplicado", "Projeto de Engenharia de Software",
        "Programação de dispositivos móveis", "Programação Imperativa", "Programação Orientada a Objetos")

    private lateinit var autoCompleteTextView : AutoCompleteTextView

    private lateinit var adapterItems : ArrayAdapter<String>

    private lateinit var avancar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disciplina_a_estudar)

        autoCompleteTextView = findViewById(R.id.auto_complete_txt)

        adapterItems =  ArrayAdapter<String>(this, R.layout.list_disciplinas, item)

        avancar = findViewById(R.id.btnAvancar)

        autoCompleteTextView.setAdapter(adapterItems)

        autoCompleteTextView.setOnItemClickListener{parent, view, position, id ->
            val item = parent.getItemAtPosition(position).toString()
            Toast.makeText(applicationContext, "Item: $item", Toast.LENGTH_SHORT).show()
        }

        avancar.setOnClickListener{
            if (autoCompleteTextView.text.toString() != ""){
                val intent = Intent(this, PDM::class.java)
                startActivity(intent)
            }
        }

    }
}