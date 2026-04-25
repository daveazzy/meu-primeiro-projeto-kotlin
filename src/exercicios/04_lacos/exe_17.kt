package exercicios.`04_lacos`

fun main () {
    repeat(10){
        if (it == 0) println(it)
        else if (it == 1) println(it)
        else if (it > 1) println((it -1) + (it - 2))
    }
}