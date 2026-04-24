package exercicios.`04_lacos`

fun main () {
    var count: Int = 1

    while (count % 2 != 0 || count % 3 != 0 || count % 5 != 0 || count % 7 != 0) {
        count++
    }

    println(count)
}