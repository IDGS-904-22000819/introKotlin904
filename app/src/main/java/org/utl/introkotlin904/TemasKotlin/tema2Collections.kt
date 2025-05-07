
package org.utl.introkotlin904.TemasKotlin

// Función principal donde comienza la ejecución del programa
fun main() {

    /*
    Colecciones en Kotlin: Estructuras de datos para agrupar elementos.
    Se utilizan para almacenar, organizar y manipular conjuntos de datos.
     */

    // --- List ---
    // Qué es: Una colección ORDENADA de elementos. Permite elementos duplicados.
    // Es inmutable: Una vez creada, su contenido no se puede cambiar (añadir, eliminar, modificar).
    // Cuándo usarla: Ideal cuando el orden de los elementos es importante y la lista es fija
    //                (no va a cambiar después de su inicialización).
    val readOnlyFiguras = listOf("Circulo", "Cuadrado", "Triangulo")
    println("--- List (Inmutable) ---")
    println("Contenido: $readOnlyFiguras") // Imprime la lista completa
    println("Elemento en índice 0: ${readOnlyFiguras[0]}") // Acceso por índice
    // readOnlyFiguras.add("Elipse") // Esto daría un error de compilación porque es inmutable
    println("-----------------------\n")

    // --- MutableList ---
    // Qué es: Una colección ORDENADA de elementos que se puede MODIFICAR. Permite duplicados.
    // Es mutable: Puedes añadir, eliminar, actualizar o reordenar elementos.
    // Cuándo usarla: Cuando necesitas una lista cuyo contenido cambiará dinámicamente a lo largo
    //                de la ejecución del programa.
    val mutableFiguras = mutableListOf("Circulo", "Cuadrado", "Triangulo")
    println("--- MutableList ---")
    println("Contenido inicial: $mutableFiguras")
    mutableFiguras.add("Elipse") // Añadir un elemento
    println("Después de añadir 'Elipse': $mutableFiguras")
    mutableFiguras.remove("Cuadrado") // Eliminar un elemento
    println("Después de eliminar 'Cuadrado': $mutableFiguras")
    mutableFiguras[0] = "Óvalo" // Modificar un elemento por índice
    println("Después de modificar índice 0 a 'Óvalo': $mutableFiguras")
    println("-------------------\n")

    // NOTA: La línea 'var mutableFiguras2 = List<String>= "figura"' en tu comentario inicial
    // parece ser incorrecta en sintaxis. List<String> es un tipo, no un valor String.
    // Una forma correcta de inicializar una MutableList vacía sería:
    // var mutableFiguras2 = mutableListOf<String>()
    // O con un valor inicial:
    // var mutableFiguras2: MutableList<String> = mutableListOf("figura")


    // --- Set ---
    // Qué es: Una colección de elementos ÚNICOS. No permite duplicados.
    // Es inmutable: Una vez creada, su contenido no se puede cambiar (añadir, eliminar).
    // No garantiza orden (aunque LinkedHashSet sí mantiene orden de inserción).
    // Cuándo usarla: Cuando la unicidad de los elementos es lo principal y el orden no es relevante
    //                (o usas una implementación específica que mantenga el orden).
    val frutas = setOf("Manzana", "Banana", "Uva", "Manzana")
    println("--- Set (Inmutable) ---")
    println("Contenido: $frutas") // Notar que "Manzana" solo aparece una vez
    // frutas.add("Pera") // Esto daría un error de compilación
    println("Contiene 'Banana': ${frutas.contains("Banana")}") // Verificar existencia
    println("---------------------\n")


    // --- MutableSet ---
    // Qué es: Una colección de elementos ÚNICOS que se puede MODIFICAR. No permite duplicados.
    // Es mutable: Puedes añadir o eliminar elementos.
    // No garantiza orden (aunque MutableLinkedHashSet sí mantiene orden de inserción).
    // Cuándo usarla: Cuando necesitas una colección de elementos únicos que cambiará.
    val frutas2 = mutableSetOf("Manzana", "Banana", "Uva", "Manzana")
    println("--- MutableSet ---")
    println("Contenido inicial: $frutas2") // Notar que "Manzana" solo aparece una vez
    frutas2.add("Pera") // Añadir un elemento único
    println("Después de añadir 'Pera': $frutas2")
    frutas2.add("Manzana") // Intentar añadir un duplicado (será ignorado)
    println("Después de añadir 'Manzana' (duplicado): $frutas2")
    frutas2.remove("Banana") // Eliminar un elemento
    println("Después de eliminar 'Banana': $frutas2")
    println("------------------\n")


    // --- Map ---
    // Qué es: Una colección de pares CLAVE-VALOR. Las CLAVES son únicas. Los VALORES pueden ser duplicados.
    // Es inmutable: Una vez creada, su contenido no se puede cambiar (añadir, eliminar, actualizar pares).
    // No garantiza orden de claves (aunque LinkedHashMap sí mantiene orden de inserción).
    // Cuándo usarla: Cuando necesitas almacenar asociaciones entre datos (clave a valor) que son fijas.
    val coches = mapOf("uno" to 1, "dos" to 2, "tres" to 3)
    println("--- Map (Inmutable) ---")
    println("Contenido: $coches")
    println("Valor asociado a 'dos': ${coches["dos"]}") // Acceso por clave
    println("Claves: ${coches.keys}")
    println("Valores: ${coches.values}")
    // coches["cuatro"] = 4 // Esto daría un error de compilación
    println("---------------------\n")


    // --- MutableMap ---
    // Qué es: Una colección de pares CLAVE-VALOR que se puede MODIFICAR. Las CLAVES son únicas.
    // Es mutable: Puedes añadir, eliminar o actualizar pares clave-valor.
    // No garantiza orden de claves (aunque MutableLinkedHashMap sí mantiene orden de inserción).
    // Cuándo usarla: Cuando necesitas un mapa cuyas asociaciones cambiarán dinámicamente.
    val coches2 = mutableMapOf("uno" to 1, "dos" to 2, "tres" to 3)
    println("--- MutableMap ---")
    println("Contenido inicial: $coches2")
    coches2["cuatro"] = 4 // Añadir un nuevo par
    println("Después de añadir 'cuatro'->4: $coches2")
    coches2["uno"] = 10 // Actualizar el valor de una clave existente
    println("Después de actualizar 'uno'->10: $coches2")
    coches2.remove("dos") // Eliminar un par por clave
    println("Después de eliminar 'dos': $coches2")
    println("------------------\n")
}
