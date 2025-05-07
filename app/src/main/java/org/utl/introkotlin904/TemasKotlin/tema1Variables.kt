package org.utl.introkotlin904.TemasKotlin

fun main (){
    println("Hola Mundo!!!")

    //Variables solo lectura (val)
    //Variable mutables (var)

    // Inferencia de tipo de dato:
    // permite determinar automáticamente el tipo
    // de datos de una variable
    val a=4
    val b=8
    var c=10

    // a=8 no se puede porque es de solo lectura
    println(a)
    println("El valor de b es: $b")
    println("El valor de c es: ${c+2}")

    c=a+2
    c+=8
    c-=5
    c*8
    c/=2
    println("El valor de c es: ${c+2}")

    var num1:Int=23
    var num2:Int=12

    num2=5


    var nombre:String="Carlos"
    var caracter:Char='a'

    var num4:Float=12.5f // En numeros flotantes hay que poner la f si no sale error
    var num5:Double=12.5
}