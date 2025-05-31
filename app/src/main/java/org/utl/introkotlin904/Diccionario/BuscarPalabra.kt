package org.utl.introkotlin904.Diccionario

import android.content.Context // No es estrictamente necesario aquí si no usas MODE_APPEND, pero sí para openFileInput
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast // Necesario para Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin904.R
import java.io.FileNotFoundException // Necesario para capturar si el archivo no existe
import java.io.IOException // Para otros errores de lectura de archivo

class BuscarPalabra : AppCompatActivity() {

    val FILENAME = "diccionario.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscar_palabra)

        val btn1 = findViewById<Button>(R.id.regresarMenu)
        val btn2 = findViewById<Button>(R.id.Buscar)


        val radioEspaniol = findViewById<RadioButton>(R.id.radioEspaniol)
        val radioIngles = findViewById<RadioButton>(R.id.radioIngles)
        val textPalabra = findViewById<TextView>(R.id.textPalabra)

        val resultado = findViewById<TextView>(R.id.textresultado)
        val inputTexto = findViewById<EditText>(R.id.editTextText)

        btn1.setOnClickListener {
            navegateToMenu()
        }

        btn2.setOnClickListener {
            val palabraABuscar = inputTexto.text.toString().trim()

            if (palabraABuscar.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa una palabra para buscar.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val buscarEnInglesSeleccionado = radioIngles.isChecked

            val traduccionEncontrada = buscarTraduccionEnArchivo(palabraABuscar, buscarEnInglesSeleccionado)
            resultado.text = "Palabra encontrada"
            textPalabra.text =traduccionEncontrada
        }

        val mainLayout = findViewById<android.view.View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun buscarTraduccionEnArchivo(palabra: String, buscarEnIngles: Boolean): String {
        try {
            openFileInput(FILENAME).bufferedReader().useLines { lines ->
                for (linea in lines) {
                    val partes = linea.split('|')
                    if (partes.size == 2) {
                        val palabraInglesEnArchivo = partes[0].trim()
                        val palabraEspanolEnArchivo = partes[1].trim()

                        if (buscarEnIngles) {
                            if (palabraInglesEnArchivo.equals(palabra, ignoreCase = true)) {
                                return palabraEspanolEnArchivo
                            }
                        } else {
                            if (palabraEspanolEnArchivo.equals(palabra, ignoreCase = true)) {
                                return palabraInglesEnArchivo
                            }
                        }
                    }
                }
            }
            return "Palabra no encontrada "
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            return "El archivo del diccionario no existe. Agrega palabras primero."
        } catch (e: IOException) {
            e.printStackTrace()
            return "Error al leer el diccionario"
        } catch (e: Exception) {
            e.printStackTrace()
            return "Ocurrió un error inesperado"
        }
    }

    private fun navegateToMenu() {
        val intent = Intent(this, MenuDiccionario::class.java)
        startActivity(intent)

    }
}