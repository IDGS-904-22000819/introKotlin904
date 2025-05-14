package org.utl.introkotlin904.tema1App

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin904.R
import kotlin.properties.Delegates

class Ejemplo2Activity : AppCompatActivity() {

    lateinit var num1: EditText
    lateinit var num2: EditText
    lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo2)

        num1= findViewById<EditText>(R.id.num1)
        num2=findViewById<EditText>(R.id.num2);
        resultado=findViewById<TextView>(R.id.resultado);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcularSuma (view: android.view.View){
        var valor1String = num1.text.toString()
        var valor2String = num2.text.toString()

        if (valor1String.isEmpty() || valor2String.isEmpty()){
            resultado.text = "Error"
            return
        }

        var valor1 = valor1String.toInt()
        var valor2 = valor2String.toInt()
        var suma:String=""
        var resultadoSuma:Int=0

        if (valor2<=0){
            resultado.text = "Error"
            return
        }

        for (i in 1..valor2){
            resultadoSuma+=valor1
            if (i==valor2){
                suma+="$valor1"
                resultado.text = "$suma = $resultadoSuma"
            }else{
                suma+="$valor1 + "
            }
        }

    }
}