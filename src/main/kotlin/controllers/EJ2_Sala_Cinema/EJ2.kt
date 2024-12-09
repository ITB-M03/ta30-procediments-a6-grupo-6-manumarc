package org.example.controllers

import java.util.Scanner

/**
 * Punto de entrada principal del programa. Inicializa la sala, maneja la opción recibida por el usuario y cierra el Scanner.
 * @author Manuel Félix
 * @since 9/12/2024
 */
fun main() {
    val scan = abrirScanner()
    val sala = inicializarSala()
    manejarOpciones(scan, sala)
    cerrarScanner(scan)
}

/**
 * Inicializa una matriz (sala de cine) con 20 filas y 15 butacas por fila, todas marcadas como libres ('_').
 * @return devuelve la sala (matriz) con los asientos libres.
 * @author Manuel Félix
 */
fun inicializarSala(): Array<CharArray> {
    return Array(20) { CharArray(15) { '_' } }
}

/**
 * Se encarga de manejar las opciones que el usuario elige en el menú.
 * El programa sigue ejecutándose hasta que el usuario elige salir.
 * @param scan el Scanner para leer la entrada del usuario.
 * @param sala la sala de cine, se representa como una matriz.
 * @author Manuel Félix
 */

fun manejarOpciones(scan: Scanner, sala: Array<CharArray>) {
    var salir = false
    while (!salir) {
        menu()
        when (scan.nextInt()) {
            1 -> vaciarSala(sala)
            2 -> asientosDisponibles(sala)
            3 -> reservaDeAsientos(sala, scan)
            4 -> {
                salir = true
                println("¡Gracias, hasta la próxima!")
            }
            else -> println("Esta opción no es válida.")
        }
    }
}

/**
 * Muestra el menú principal del programa con las opciones disponibles.
 * @author Manuel Félix
 */
fun menu() {
    println("-¿Qué deseas hacer?-")
    println("1. Vaciar sala")
    println("2. Visualizar asientos disponibles")
    println("3. Reservar asientos")
    println("4. Salir")
    print("Selecciona una opción del 1 al 4: ")
}

/**
 * Vacía la sala de cine, marcando todas las butacas como libres ('_').
 * @param sala la sala de cine, se representa como una matriz.
 * @author Manuel Félix
 */
fun vaciarSala(sala: Array<CharArray>) {
    for (fila in sala) fila.fill('_')
    println("La sala se ha vaciado correctamente.")
}

/**
 * Muestra el estado actual de la sala, indica los asientos libres ('_') y reservados ('X').
 * @param sala la sala de cine, se representa como una matriz.
 * @author Manuel Félix
 */
fun asientosDisponibles(sala: Array<CharArray>) {
    println("-Estado de la sala-")
    for (fila in sala) println(fila.joinToString(" "))
}

/**
 * Solicita al usuario las coordenadas de fila y butaca, y realiza la reserva si el asiento está disponible.
 * @param sala la sala de cine, se representa como una matriz.
 * @param scan el scanner para leer las coordenadas que inserta el usuario.
 * @author Manuel Félix
 *
 */
fun reservaDeAsientos(sala: Array<CharArray>, scan: Scanner) {
    print("Introduce la fila en la que deseas sentarte (1-20): ")
    val fila = scan.nextInt() - 1
    print("Introduce la butaca en la que deseas sentarte (1-15): ")
    val butaca = scan.nextInt() - 1

    if (fila in sala.indices && butaca in sala[0].indices) {
        if (sala[fila][butaca] == '_') {
            sala[fila][butaca] = 'X'
            println("La reserva se ha realizado con éxito.")
        } else {
            println("El asiento ya ha sido reservado por otra persona.")
        }
    } else {
        println("Asientos no existentes.")
    }
}

/**
 * Abre el Scanner para leer las entradas del usuario
 * @author Manuel Félix
 */
fun abrirScanner(): Scanner = Scanner(System.`in`)

/**
 * Cierra el Scanner utilizado para la entrada del usuario.
 * @param scan para cerrar el scanner
 * @author Manuel Félix
 */
fun cerrarScanner(scan: Scanner) {
    scan.close()
}

