package aula_10_colecoes

// array

fun main() {
    val array: Array<Int> = arrayOf(1, 2, 3, 4,5)
    val array2: Array<String> = arrayOf("1", "2", "3")

    println(array) // isso aqui vai mostrar a memoria alocada
    println(array2)

    // para mostrar os valores, precisa usar joinToString

    println(array.joinToString())
    println(array2.joinToString())

    // ele vai estar disponivel em qualquer colecao que voce criar

    println(array.joinToString(prefix = "[", postfix = "]", separator = " | "))

    // ------------------------------

    // somando arrays

    val array3: Array<Int> = arrayOf(6, 7, 8, 9, 10)

    val arraySum = array + array3

    // ou

    val arraySum2 = array.plus(array3)

    println(arraySum.joinToString()) // concatena os arrays
    println(arraySum2.joinToString())

    // eh impossivel somar arrays de diferentes tipos
}