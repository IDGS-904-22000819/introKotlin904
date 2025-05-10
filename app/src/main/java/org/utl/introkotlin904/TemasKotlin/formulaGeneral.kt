package org.utl.introkotlin904.TemasKotlin
import kotlin.math.pow
import kotlin.math.sqrt




fun main (){

    var a:Double=0.0
    var b:Double=0.0
    var c:Double=0.0

    var validacion:Boolean=true

    while (validacion) {

        println("Ingresa el valor de a: ")
        a = readln().toDouble()
        if (a == 0.0) {
            println("\nEl valor de 'a' no puede ser cero, para evitar division por cero ingrese otro valor")
        }else{
            validacion=false
        }
    }

    println("Ingresa el valor de b: ")
    b = readln().toDouble()

    println("Ingresa el valor de c: ")
    c = readln().toDouble()

    val operacionInterna = b.pow(2) - 4 * a * c

    if (operacionInterna < 0) {
        println("Al realizar la operacion se obtiene un numero negativo")
        println ("No se puede realizar la operacion")
    }else {
        var raiz= sqrt(operacionInterna)
        var x1 = (-b + raiz) / (2 * a)
        var x2 = (-b - raiz) / (2 * a)
        println("El valor de x1 es: $x1")
        println("El valor de x2 es: $x2")
    }



    }