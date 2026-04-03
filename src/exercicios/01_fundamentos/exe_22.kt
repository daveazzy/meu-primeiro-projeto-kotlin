package exercicios.`01_fundamentos`

fun main () {
    val string: String = "abc"

    try {
        string.toInt()
    } catch (err: NumberFormatException) {
        println("Não é possível converter 'abc' para número inteiro")
    }
}