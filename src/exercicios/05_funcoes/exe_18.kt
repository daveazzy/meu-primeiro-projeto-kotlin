package exercicios.`05_funcoes`

infix fun Int.eMaiorQue(n: Int): Boolean = this > n
infix fun String.temTamanho(n: Int): Boolean = this.length >= n

fun main () {
    val resultado = 5 eMaiorQue 3
    val resultado2 = "Kotlin" temTamanho 6

    println(resultado)
    println(resultado2)
}