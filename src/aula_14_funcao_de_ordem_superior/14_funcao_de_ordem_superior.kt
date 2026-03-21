package aula_14_funcao_de_ordem_superior

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun subtract(a: Int, b: Int): Int = a - b

fun multiply(a: Int, b: Int) = a * b

fun mathOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}


fun main() {
    val divide = {a: Int, b: Int -> a / b}

    println(mathOperation(1, 2, operation = ::sum))
    println(mathOperation(1, 2, operation = ::subtract))
    println(mathOperation(1, 2, operation = ::multiply))

    // podemos passar divide, porque val divide está na formatação correta
    println(mathOperation(1, 2, operation = divide))


    // estudar mais essa aula
}