package exercicios.`01_fundamentos`

fun main () {
    var notaFinal: Float = readln().toFloat()

    if (notaFinal < 5) println("Reprovado")
    else if (notaFinal in 5.0..6.0) println("Recuperaçao")
    else println ("Aprovado")
}