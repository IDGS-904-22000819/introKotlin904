package org.utl.introkotlin904.PracticaPalindromo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin904.R
import org.utl.introkotlin904.tema1App.Ejemplo1Activity

class palindromoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_palindromo)

        val palabraEditText = findViewById<EditText>(R.id.palabra)
        val btnVerificar = findViewById<Button>(R.id.btnVerificar)
        val textResultado = findViewById<TextView>(R.id.textResultado)

        btnVerificar.setOnClickListener {
            val palabra = palabraEditText.text.toString()
            val esPalindromo = verificarPalindromo(palabra)
            if (esPalindromo) {
                Toast.makeText(this, "Es un palindromo", Toast.LENGTH_SHORT).show()
                palabraEditText.text.clear()
                navegateToResultadoPalindromo(palabra)
                textResultado.text = ""
            } else {
                Toast.makeText(this, "NO es un palindromo", Toast.LENGTH_SHORT).show()
                textResultado.text = "No es un palindromo"
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun verificarPalindromo(palabra: String): Boolean {
        val palabraMinusculas = palabra.toLowerCase()
        val palabraAlreves = palabraMinusculas.reversed()
        if (palabraMinusculas == palabraAlreves) {
            return true
        }else{
            return false
        }
    }

    private fun navegateToResultadoPalindromo(palabra: String) {
        val intent = Intent(this, ResultadoActivity::class.java)
        intent.putExtra("palabra",palabra)
        startActivity(intent)
    }


}