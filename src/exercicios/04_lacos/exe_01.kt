package exercicios.`04_lacos`

fun main () {
    for (i in 1..20){
        if (i % 3 == 0) println("Fizz")
        if (i % 5 == 0) println("Buzz")
        if (i % 3 == 0 && i % 5 == 0) println("FizzBuzz")
        else println(i)
    }
}