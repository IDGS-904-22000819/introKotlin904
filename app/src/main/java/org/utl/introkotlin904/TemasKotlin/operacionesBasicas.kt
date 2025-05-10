package org.utl.introkotlin904.TemasKotlin

fun menu (){
    var opcion: Int = 0

    while (opcion != 5) {
        // Mostrar el menú de opciones
        println("\n Operaciones basicas")
        println("1-Sumar")
        println("2-Restar")
        println("3-Multiplicar")
        println("4-Dividir")
        println("5-Salir")
        println("Seleccionar una opcion: ")

        opcion=readln().toInt()

        when(opcion){
            1 -> suma()
            2 -> resta()
            3 -> multiplicacion()
            4 -> division()
            5 -> println("Fin")
            else -> println("Opcion no valida")
        }
        }
    }

fun suma(){
    println("")
    println("Ingresa el primer numero: ")
    val num1 = readln().toDouble()
    println("Ingresa el segundo numero: ")
    val num2 = readln().toDouble()
    println("Resultado Suma: $num1 + $num2 = ${num1 + num2}")
}

fun resta (){
    println("")
    println("Ingresa el primer numero: ")
    val num1 = readln().toDouble()
    println("Ingresa el segundo numero: ")
    val num2 = readln().toDouble()
    println("Resultado Resta: $num1 - $num2 = ${num1 - num2}")

}

fun multiplicacion (){
    println("")
    println("Ingresa el primer numero: ")
    val num1 = readln().toDouble()
    println("Ingresa el segundo numero: ")
    val num2 = readln().toDouble()
    println("Resultado multiplicacion: $num1 * $num2 = ${num1 * num2}")
}

fun division (){
    println("")
    println("Ingresa el dividendo: ")
    val num1 = readln().toDouble()
    println("Ingresa el divisor: ")
    val num2 = readln().toDouble()
    if (num2==0.0){
        println("No se puede dividir por cero")
        return
    }
    println("Resultado division: $num1 / $num2 = ${num1/num2}")
}

fun main (){
    menu()
}