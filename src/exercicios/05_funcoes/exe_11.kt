package exercicios.`05_funcoes`

fun executarComRetry(vezes: Int, acao: () -> Boolean): Boolean {
    for (i in 1..vezes) {
        if (acao()) {
            return true
        }
    }

    return false
}

fun main () {
    var tentativa = 0

    val resultado = executarComRetry(3, {
        tentativa++
        println("Tentativa $tentativa")
        tentativa >= 3
    })

    println("Resultado $resultado")
}