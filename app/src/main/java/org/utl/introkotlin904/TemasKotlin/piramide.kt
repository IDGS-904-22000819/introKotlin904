package org.utl.introkotlin904.TemasKotlin


fun generarPiramide(numRenglones: Int){
    var filaActual = 1
    do {
        var asteriscosEnFila = 0
        do {
            print("*")
            asteriscosEnFila++
        } while (asteriscosEnFila < filaActual)

        println()
        filaActual++
    } while (filaActual <= numRenglones)

}

fun main() {
    var numRenglones: Int

    do {
        println("Ingrese el numero de renglones:")
        numRenglones = readln().toInt()
        if (numRenglones != 0) {
            generarPiramide(numRenglones)
        } else if (numRenglones == 0) {
            println("Fin")
        } else {
            println("Entrada no valida")
        }

    } while (numRenglones != 0)

}