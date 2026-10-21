package com.example.claculadoradeimc

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar
import kotlin.String

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imc = intent.getDoubleExtra("IMC", 0.0)

        val toolbarResult = findViewById<MaterialToolbar>(R.id.toolbar_result)
        setSupportActionBar(toolbarResult)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val resultado = findViewById<TextView>(R.id.txt_resultado)
        val btnNovoCalculo = findViewById<Button>(R.id.btn_novoCalculo)
        val tvEstado = findViewById<TextView>(R.id.txt_Estado)

        resultado.text = String.format("%.2f Kg", imc)

        val classificacao = when {
            imc < 18.5 -> {
                tvEstado.setTextColor(Color.BLUE)
                "Abaixo do peso"
            }

            imc < 25.0 -> {
                tvEstado.setTextColor(Color.GREEN)
                "Peso normal"
            }

            imc < 30.0 -> {
                tvEstado.setTextColor(Color.rgb(255, 152, 0))
                "Sobrepeso"
            }

            imc < 35.0 -> {
                tvEstado.setTextColor(Color.RED)
                "Obesidade grau I"
            }

            imc < 40.0 -> {
                tvEstado.setTextColor(Color.rgb(183, 28, 28))
                "Obesidade grau II"
            }

            else -> {
                tvEstado.setTextColor(Color.rgb(156, 39, 176))
                "Obesidade grau III"
            }
        }

        tvEstado.text = classificacao
        tvEstado.text =  (classificacao)



        btnNovoCalculo.setOnClickListener {
            val intent = Intent(this, Calculo::class.java)
            startActivity(intent)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return  when(item.itemId){
            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


    }
