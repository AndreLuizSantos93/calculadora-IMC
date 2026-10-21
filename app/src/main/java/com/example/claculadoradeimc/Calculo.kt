package com.example.claculadoradeimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Calculo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Recuperar as views

        val edtPeso = findViewById<EditText>(R.id.edt_peso)
        val edtaltura = findViewById<EditText>(R.id.edtAltura)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        // calculo IMC


        btnCalcular.setOnClickListener {

            val peso = edtPeso.text.toString().replace(",", ".").toDoubleOrNull()
            val altura = edtaltura.text.toString().replace(",", ".").toDoubleOrNull()

            //se o peso e a altura seja diferente de nulo e a altura seja >0
            if (peso != null && altura != null && altura > 0) {


                val alturaFinal = altura * altura
                val imc = peso/ alturaFinal




                intent = Intent(this, Resultado::class.java)

                intent.putExtra("IMC", imc)

                startActivity(intent)

            }

        }
    }

}