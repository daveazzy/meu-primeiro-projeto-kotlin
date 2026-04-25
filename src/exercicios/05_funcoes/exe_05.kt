package exercicios.`05_funcoes`

fun main () {
    val dobrar: (Int) -> Int = { it * 2 }
    val ehMaior18: (Int) -> Boolean = { it > 18 }
    val concatenar: (String, String) -> String = { a, b -> "$a $b" }

    println(dobrar(2))
    println(ehMaior18(2))
    println(concatenar("Davidson", "Oliveira"))
}