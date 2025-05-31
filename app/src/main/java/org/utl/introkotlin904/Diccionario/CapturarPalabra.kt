package org.utl.introkotlin904.Diccionario

import android.content.Context // Necesario para Context.MODE_APPEND
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast // Necesario para Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog // Necesario para AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin904.R
import java.io.IOException // Más específico para errores de archivo

class CapturarPalabra : AppCompatActivity() {

    val FILENAME = "diccionario.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capturar_palabra)

        val btn1 = findViewById<Button>(R.id.regresarMenu)
        val btn2 = findViewById<Button>(R.id.guardar)

        val espaniol = findViewById<EditText>(R.id.espaniolEditText)
        val ingles = findViewById<EditText>(R.id.inglesEditText)
        val resultado = findViewById<TextView>(R.id.textresultado)

        btn1.setOnClickListener {
            navegateToMenu()
        }

        btn2.setOnClickListener {
            val palabraIngles = ingles.text.toString().trim()
            val palabraEspanol = espaniol.text.toString().trim()

            if (palabraIngles.isNotEmpty() && palabraEspanol.isNotEmpty()) {
                guardarPalabrasEnArchivo(palabraIngles, palabraEspanol)
                ingles.text.clear()
                espaniol.text.clear()

                resultado.text = "Palabra guardada con exito"

            } else {
                Toast.makeText(this, "Por favor completa ambos campos", Toast.LENGTH_LONG).show()
            }
        }

        val mainLayout = findViewById<android.view.View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun guardarPalabrasEnArchivo(palabraIngles: String, palabraEspanol: String) {
        try {
            val fileContent = "$palabraIngles|$palabraEspanol\n"

            openFileOutput(FILENAME, Context.MODE_APPEND).use { outputStream ->
                outputStream.write(fileContent.toByteArray())
            }
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "Error al guardar el archivo: ${e.message}", Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Ocurrió un error inesperado: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun navegateToMenu() {
        val intent = Intent(this, MenuDiccionario::class.java)
        startActivity(intent)
    }
}