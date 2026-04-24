package exercicios.`04_lacos`

fun main () {
    val lista = listOf(5, 3, 8, 12, 1, 7, 15, 4)

    for ((index, i) in lista.withIndex()) {
        if (i == 12) {
            println("$index is ${lista[index]}")
            break
        }
    }
}