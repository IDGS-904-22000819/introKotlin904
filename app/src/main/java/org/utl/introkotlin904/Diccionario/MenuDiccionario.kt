package org.utl.introkotlin904.Diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin904.R
import org.utl.introkotlin904.tema1App.Ejemplo1Activity

class MenuDiccionario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_diccionario)

        val btn1 = findViewById<Button>(R.id.BuscarPalabra)
        val btn2 = findViewById<Button>(R.id.CapturarPalabra)

        btn1.setOnClickListener {
            navegateToBuscarPalabra()
        }
        btn2.setOnClickListener {
            navegateToCapturarPalabra()

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

        }
    }

    private fun navegateToCapturarPalabra() {
        val intent = Intent(this, CapturarPalabra::class.java)
        startActivity(intent)
    }

    private fun navegateToBuscarPalabra() {
        val intent = Intent(this, BuscarPalabra::class.java)
        startActivity(intent)
    }

}


