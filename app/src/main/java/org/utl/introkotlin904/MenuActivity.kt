package org.utl.introkotlin904

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin904.PracticaPalindromo.palindromoActivity
import org.utl.introkotlin904.Tema3.Ejemplo4Activity
import org.utl.introkotlin904.Tema4.Ejemplo5Activity
import org.utl.introkotlin904.tema1App.Cinepolis
import org.utl.introkotlin904.tema1App.Ejemplo1Activity
import org.utl.introkotlin904.tema1App.Ejemplo2Activity
import org.utl.introkotlin904.tema2App.Ejemplo3Activity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)


        btn1.setOnClickListener {
            navegateToEjemplo1()
        }
        btn2.setOnClickListener {
            navegateToEjemplo2()
        }

        btn3.setOnClickListener {
            navegateToCine()
        }

        btn4.setOnClickListener {
            navegateToEjemplo3()
        }

        btn5.setOnClickListener {
            navegateToEjemplo4()
        }

        btn6.setOnClickListener {
            navegateToEjemplo5()
        }

        btn7.setOnClickListener {
            navegateToPalindromo()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    private fun navegateToEjemplo1() {
        val intent = Intent(this, Ejemplo1Activity::class.java)
        startActivity(intent)
    }
    private fun navegateToEjemplo2() {
        val intent = Intent(this, Ejemplo2Activity::class.java)
        startActivity(intent)
    }

    private fun navegateToCine() {
        val intent = Intent(this, Cinepolis::class.java)
        startActivity(intent)
    }

    private fun navegateToEjemplo3() {
        val intent = Intent(this, Ejemplo3Activity::class.java)
        startActivity(intent)
    }

    private fun navegateToEjemplo4() {
        val intent = Intent(this, Ejemplo4Activity::class.java)
        startActivity(intent)
    }

    private fun navegateToEjemplo5() {
        val intent = Intent(this, Ejemplo5Activity::class.java)
        startActivity(intent)
    }

    private fun navegateToPalindromo() {
        val intent = Intent(this, palindromoActivity::class.java)
        startActivity(intent)
    }

}