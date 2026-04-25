package exercicios.`04_lacos`

fun ehPrimo(n: Int): Boolean {
    var count = 0
    for (i in 1..n) {
        if (n % i == 0) count++
    }

    return count == 2
}

fun main () {
    for (i in 1..100){
        if (ehPrimo(i)) {
            println(i)
        }
    }
}