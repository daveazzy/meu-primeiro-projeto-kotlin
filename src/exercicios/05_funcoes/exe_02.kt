package exercicios.`05_funcoes`

fun calcularMedia(vararg numbers: Double): Double {
    return numbers.sum() / numbers.size
}

fun main () {
    var nota1: Double = 8.9
    var nota2: Double = 6.8
    var nota3: Double = 8.0

    var media: Double = calcularMedia(nota1, nota2, nota3)
    println(media)
}