package exercicios.`05_funcoes`

import java.lang.Math.pow
import kotlin.math.pow

infix fun Int.elevadoA(exp: Int): Double = this.toDouble().pow(exp.toDouble())
infix fun String.repetir(vezes: Int): String = this.repeat(vezes)
infix fun <T> T.estaEm(lista: List<T>): Boolean = this in lista

fun main () {
    val exponencial = 2 elevadoA 2
    val texto = "Dave " repetir 3
    val lista = 2 estaEm listOf(1, 4, 3)

    println(exponencial)
    println(texto)
    println(lista)
}