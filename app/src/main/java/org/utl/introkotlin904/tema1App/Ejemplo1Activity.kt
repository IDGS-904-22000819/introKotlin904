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



class Ejemplo1Activity : AppCompatActivity() {
    // El lateinit indica que se inicializará más tarde
    lateinit var et1: EditText
    lateinit var et2: EditText
    lateinit var tv1: TextView
    lateinit var radioGroupOperaciones: RadioGroup
    lateinit var rbSuma: RadioButton
    lateinit var rbResta: RadioButton
    lateinit var rbMultiplicacion: RadioButton
    lateinit var rbDivision: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo1)

        et1 = findViewById<EditText>(R.id.et1)
        et2 = findViewById<EditText>(R.id.et2)
        tv1 = findViewById<TextView>(R.id.tv1)
        radioGroupOperaciones = findViewById(R.id.radioGroup)

        rbSuma = findViewById(R.id.suma)
        rbResta = findViewById(R.id.resta)
        rbMultiplicacion = findViewById(R.id.multiplicacion)
        rbDivision = findViewById(R.id.division)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
    fun calcular(view: android.view.View) {

        var valor1String = et1.text.toString()
        var valor2String = et2.text.toString()

        if (valor1String.isEmpty() || valor2String.isEmpty()) {
            tv1.text = "Error"
            return
        }

        var valor1 = valor1String.toDouble()
        var valor2 = valor2String.toDouble()

        var resultado = 0.0

        if (rbSuma.isChecked) {
            resultado = valor1 + valor2
            tv1.text = resultado.toString()
        } else if (rbResta.isChecked) {
            resultado = valor1 - valor2
            tv1.text = resultado.toString()
        } else if (rbMultiplicacion.isChecked) {
            resultado = valor1 * valor2
            tv1.text = resultado.toString()
        } else if (rbDivision.isChecked) {
            if (valor2 == 0.0) {
                tv1.text = "Error"
            } else {
                resultado = valor1 / valor2
                tv1.text = resultado.toString()
            }
        } else {
            tv1.text = "Selecciona una operación"
        }
    }

}

//Programa que nos permita calcular la