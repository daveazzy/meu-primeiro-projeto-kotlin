package exercicios.`04_lacos`

fun main () {
    for (i in 1..50){
        if (i % 3 == 0 && i % 7 == 0) continue

        println(i)
    }
}