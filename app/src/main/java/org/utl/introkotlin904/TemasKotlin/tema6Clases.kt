package org.utl.introkotlin904.TemasKotlin

class usuarios(){
    val materia:String=""
}

//Se puede poner los atributos dentro de los parentesis como si fuera un constructor
class usuarios2(val id:Int, val nombre:String){
    val materia:String="";
    fun hola (){

        /*

        */
        println("Hola")
        println("Hola $nombre")
    }
}

fun main (){
    val  alumno= usuarios()
    val  alumno2= usuarios2(1,"Carlos")

    println(alumno2.id)
    println(alumno2.nombre)
}