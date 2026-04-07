package exercicios.colecoes

fun main () {
    val impar: Array<Int> = arrayOf(1,3,5,7,9)
    val par: Array<Int> = arrayOf(2, 4, 6, 8, 10)

    val soma = impar.plus(par)

    println(soma.sorted().joinToString(
        prefix = "{",
        postfix = "}",
        separator = ", "
    ))
}