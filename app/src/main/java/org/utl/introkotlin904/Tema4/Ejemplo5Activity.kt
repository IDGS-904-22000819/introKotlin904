package org.utl.introkotlin904.Tema4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin904.R
import java.io.FileNotFoundException

class Ejemplo5Activity : AppCompatActivity() {
    private val fileName = "datos.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo5)

        val inputText = findViewById<EditText>(R.id.inputText)
        val outputText = findViewById<TextView>(R.id.outputText)
        val readButton = findViewById<Button>(R.id.readButton)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val deleteButton = findViewById<Button>(R.id.btnBorrar)

        deleteButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmación")
            builder.setMessage("¿Estás seguro de que deseas borrar el contenido del archivo '$fileName'?")

            builder.setPositiveButton("Sí") { dialog, _ ->
                try {
                    openFileOutput(fileName, MODE_PRIVATE).use {
                        it.write("".toByteArray())
                    }
                    Toast.makeText(this, "Contenido borrado", Toast.LENGTH_SHORT).show()
                    outputText.text = ""
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(this, "Error al borrar archivo.", Toast.LENGTH_SHORT).show()
                }
            }

            builder.setNegativeButton("No") { dialog, _ ->
                Toast.makeText(this, "Borrado cancelado", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            builder.create().show()
        }

        saveButton.setOnClickListener {
            val text = inputText.text.toString() + "\n"
            try {
                openFileOutput(fileName, MODE_APPEND).use {
                    it.write(text.toByteArray())
                }
                inputText.text.clear()
                Toast.makeText(this, "Texto guardado", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this, "Error al guardar texto.", Toast.LENGTH_SHORT).show()
            }
        }

        readButton.setOnClickListener {
            try {
                val contenido = openFileInput(fileName).bufferedReader().useLines { lines ->
                    lines.joinToString("\n")
                }
                outputText.text = contenido
            } catch (e: FileNotFoundException) {
                outputText.text = "El archivo no existe"
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this, "Error al leer archivo.", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
