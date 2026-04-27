package exercicios.`05_funcoes`

fun aplicarDuasVezes(value: Int,operation: (Int) -> Int): Int {
    return operation(value)
}

fun main () {
    val result = aplicarDuasVezes(5, {value -> value *2})
    val anotherResult = aplicarDuasVezes(5, {value -> value + 3})

    println("$result, $anotherResult")
}