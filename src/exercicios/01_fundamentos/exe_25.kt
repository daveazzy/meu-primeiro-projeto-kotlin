package exercicios.`01_fundamentos`

fun main () {
    var string: String = "abc"

    try {
        string.toInt()
    } catch (err: NumberFormatException) {
        println("Não é possível converter 'abc' para número inteiro")
    } finally {
        string = "-1"

        println(string.toInt())
    }
}