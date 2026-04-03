package exercicios.`01_fundamentos`

fun main () {
    var notaFinal = readln().toFloat()

    when (notaFinal) {
        in 0.0 .. 4.9 -> println("Reprovado")
        in 5.0 .. 5.9 -> println("Recuperação")
        in 6.0 .. 10.0 -> println("Aprovado")
    }
}