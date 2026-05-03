package exercicios.`06_classes`

import kotlin.math.sqrt

data class Ponto(val x: Double, val y:Double) {
    fun distacia(outro: Ponto): Double {
        return sqrt((x * x) + (y * y))
    }
}

fun main() {
    val ponto1 = Ponto(2.0, 2.0)
    val ponto2 = Ponto(6.0, 9.0)

    println(ponto1.distacia(ponto2))

    val (x, y) = ponto2
    println(x)
    println(y)
}