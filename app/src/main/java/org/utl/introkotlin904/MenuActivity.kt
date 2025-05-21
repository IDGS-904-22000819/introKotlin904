package org.utl.introkotlin904

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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

}