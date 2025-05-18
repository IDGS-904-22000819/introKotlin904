package org.utl.introkotlin904.tema1App

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin904.R

class Cinepolis : AppCompatActivity() {

    private lateinit var nombreEditText: EditText
    private lateinit var compradoresEditText: EditText
    private lateinit var radioGroupTarjeta: RadioGroup
    private lateinit var radioSi: RadioButton
    private lateinit var radioNo: RadioButton
    private lateinit var boletosEditText: EditText
    private lateinit var textResultado: TextView
    private lateinit var buttonCalcular: Button
    private lateinit var textMensaje: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis)

        nombreEditText = findViewById(R.id.nombreEditText)
        compradoresEditText = findViewById(R.id.compradoresEditText)
        radioGroupTarjeta = findViewById(R.id._tarjeta)
        radioSi = findViewById(R.id.radio_si)
        radioNo = findViewById(R.id.radio_no)
        boletosEditText = findViewById(R.id.boletosEditText)
        textResultado = findViewById(R.id.textresultado)
        buttonCalcular = findViewById(R.id.calcular)
        textMensaje = findViewById(R.id.textmensaje)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcular (view: android.view.View){
        if (camposVacios()) {
            textMensaje.text = "Faltan completar datos"
            return
        }
        realizarCalculo()
    }

    private fun camposVacios(): Boolean {
        return nombreEditText.text.toString().trim().isEmpty() ||
                compradoresEditText.text.toString().trim().isEmpty() ||
                boletosEditText.text.toString().trim().isEmpty() ||
                !radioSi.isChecked && !radioNo.isChecked
    }

    private fun realizarCalculo() {
            val compradores = compradoresEditText.text.toString().toInt()
            val boletos = boletosEditText.text.toString().toInt()
            val tieneTarjeta = radioSi.isChecked
            var boletoPrecio:Double = 12.0
            var precioFinal:Double =boletoPrecio*boletos.toDouble()

            if (compradores <= 0 || boletos <= 0) {
                textMensaje.text = "Los valores deben ser mayores a cero"
                return
            }

        if (boletos > compradores*7 ) {
            textMensaje.text = "Máximo 7 boletos por persona"
            return
        }

        if (boletos>5){
            precioFinal = precioFinal-(((precioFinal)*15)/100)
        }else if (boletos>=3 && boletos<=5){
            precioFinal = precioFinal-(((precioFinal)*10)/100)
        }

        if (tieneTarjeta) {
            precioFinal = precioFinal-((precioFinal *10)/100)
        }

        textResultado.text = "Total a pagar: $$precioFinal"
        textMensaje.text = ""

    }
}