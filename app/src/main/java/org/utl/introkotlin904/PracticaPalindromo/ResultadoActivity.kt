package org.utl.introkotlin904.PracticaPalindromo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin904.MenuActivity
import org.utl.introkotlin904.R

class ResultadoActivity : AppCompatActivity() {

    val vocales = listOf('a', 'e', 'i', 'o', 'u')
    val consonantes = listOf(
        'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
        'n', 'ñ', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado2)
        val palabra:String=intent.extras?.getString("palabra").orEmpty()
        val palabraAlreves = palabra.reversed()
        val tvPalindromeStatus= findViewById<TextView>(R.id.tvPalindromeStatus)
        val tvOriginalString = findViewById<TextView>(R.id.tvOriginalString)
        val tvReversedString = findViewById<TextView>(R.id.tvReversedString)
        val tvVowels = findViewById<TextView>(R.id.tvVowels)
        val tvConsonantsCount = findViewById<TextView>(R.id.tvConsonantsCount)
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            navegateToMenu()
        }

        val encontradas = mutableSetOf<Char>()

        tvPalindromeStatus.text = "Es un palindromo"
        tvOriginalString.text = "Original: $palabra"
        tvReversedString.text = "Al revés: $palabraAlreves"

        for (letra in palabra.lowercase()) {
            if (letra in vocales) {
                encontradas.add(letra)
            }
        }

        var resultado = ""
        for (i in 0 until encontradas.size) {
            resultado += encontradas.elementAt(i)
            if (i < encontradas.size - 1) {
                resultado += ", "
            }
        }

        tvVowels.text = "Vocales: $resultado"

        var contador = 0

        for (letra in palabra.lowercase()) {
            if (letra in consonantes) {
                contador++
            }
        }

        tvConsonantsCount.text = "Cantidad consonantes: $contador"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navegateToMenu() {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }

}