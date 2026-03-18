package aula_04_operadores_logicos

fun main() {
    val a = true
    val b = false
    val c = true

    val result = a && b

    println(result)

    val result2 = a || c
    println(result2)

    val d = true
    val e = !d

    println(e)

    val num1 = 10
    val num2 = 5

    println(num1 == num2)
    println(num1 != num2)


    // operadores de tipo

    println("---------------------------------")

    val num: Any = 1
    val numText: Any = "1"

    println(num is String)
    println(num is Int)
    println(numText is String)

    println(num !is String)

    // operadores pertence ou nao pertence (in e !in)

    println("--------------------------------------")
    val range = 1 .. 10
    val x = 5
    val y = 15

    println(x in range)
    println(y in range)

    println(x !in range)
    println(y!in range)
}