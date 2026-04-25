package exercicios.`05_funcoes`

fun main () {
    var chamadas = 0
    val contador: () -> Int = { chamadas ++ }

    for (i in 1..5){
        contador()
    }

    println(chamadas)
}