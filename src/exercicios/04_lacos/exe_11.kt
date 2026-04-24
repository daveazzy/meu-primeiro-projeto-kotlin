package exercicios.`04_lacos`

fun main () {
    for (i in 1..100) {
        println(i)

        if (i % 13 == 0 && i % 7 == 0) break
    }
}