package exercicios.`01_fundamentos`

fun main () {
    var a = readln().toFloat()
    var b = readln().toFloat()

    var max: Float = if (a > b) a else b
    println("Max: $max")
}