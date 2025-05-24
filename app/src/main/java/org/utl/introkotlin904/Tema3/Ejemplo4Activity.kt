package org.utl.introkotlin904.Tema3

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin904.R

class Ejemplo4Activity : AppCompatActivity() {
    private lateinit var ed1: EditText
    private var num=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo4)
        ed1=findViewById(R.id.ed1)
        num=(Math.random()*100001).toInt()
        val cadena =num.toString()
        val notificaciones= Toast.makeText(this,cadena,Toast.LENGTH_SHORT)
        notificaciones.show()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun controlar(view: android.view.View) {
        val valorIngresado: String= ed1.text.toString()
        val valor= valorIngresado.toInt()
        if (valor== num){
            val notificaciones= Toast.makeText(this,"Correcto",Toast.LENGTH_SHORT)
            notificaciones.show()
        }else{
            val notificaciones= Toast.makeText(this,"Incorrecto",Toast.LENGTH_SHORT)
            notificaciones.show()
        }
    }
}