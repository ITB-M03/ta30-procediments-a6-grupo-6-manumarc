package controllers.EJ1
import java.text.DecimalFormat

data class Punt (
    var x:Float,
    var y:Float,
)

/**
 * Función principal donde se ejecuta el programa.
 * Se declaran 2 variables y se usan para comprovar
 * el funcionamiento de las distintas funciones.
 * @author Marc Diaz
 */
fun main(){
    val puntoA = Punt(2f, 0.2f)
    val puntoB = Punt(5.4f, 3.14159f)
    mostrarPunt(puntoA)
    translacion(puntoA, puntoB)
    mostrarPunt(puntoA)
    escalar(puntoA, 3f)
    mostrarPunt(puntoA)

}

/**
 * Muestra por pantalla el paramatro con un formato concreto
 * @param punto Punto que se quiere mostrar por pantalla
 * @author Marc Diaz
 */
fun mostrarPunt(punto: Punt){
    println("(${DecimalFormat("0.000000").format(punto.x)},${DecimalFormat("0.000000").format(punto.y)})")
}

/**
 * Suma el segundo punto al primer punto
 * @param puntoA primer punto que se va a modificar
 * @param puntoB cantidad que se quiere mover el anterior punto
 *@author Marc Diaz
 */
fun translacion(puntoA: Punt, puntoB: Punt){
    puntoA.x += puntoB.x
    puntoA.y += puntoB.y
}

/**
 * Escala el primer punto punto teniendo en cuenta el float de escala
 * @param puntoA escala este punto teniendo en cuenta el factor escala
 * @param escala factor por el cual se escalara el punto
 * @author Marc Diaz
 */
fun escalar(puntoA: Punt, escala: Float){
    puntoA.x *= escala
    puntoA.y *= escala
}

/**
 * Comprueva si ambos puntos son iguales y devuelve true
 * si són iguales y false si son diferentes.
 * @param puntoA primer punto a comparar
 * @param puntoB segundo punto a comparar
 * @author Marc Diaz
 */
fun sonIguales(puntoA: Punt, puntoB: Punt): Boolean{
    var resultado = false
    if (puntoA.x == puntoB.x && puntoA.y == puntoB.y) resultado = true
    return resultado
}