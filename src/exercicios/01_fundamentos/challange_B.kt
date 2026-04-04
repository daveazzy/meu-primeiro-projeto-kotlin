package exercicios.`01_fundamentos`

fun main () {
    val ano = readln().toInt()

    if (ano % 4 == 0 && ano % 100 != 0) {
        println("$ano é um ano bissexto")
    } else {
        println("$ano não é um ano bissexto")
    }
}