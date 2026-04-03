package exercicios.`01_fundamentos`

fun main () {
    val temperatura: Int = readln().toInt()

    if (temperatura > 20 && temperatura < 35) println("Temperatura agradável")
    if (temperatura < 0 || temperatura > 40) println ("Temperatura extrema")
}