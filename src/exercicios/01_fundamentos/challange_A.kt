package exercicios.`01_fundamentos`

fun main () {
    print("Digite o número 1: ")
    var number1 = readln().toDouble()

    print("Digite o número 2: ")
    var number2 = readln().toDouble()

    print("Qual operação você quer fazer? (+ , - , * , /)")
    var operacao = readln()


    var resultado: Any

    try {
        resultado = when (operacao) {
            "+" -> number1 + number2
            "-" -> number1 - number2
            "*" -> number1 * number2
            "/" -> number1 / number2
            else -> "Digite uma operação válida"
        }

        if (operacao == "/" && number2 == 0.0) {
            throw IllegalArgumentException("Não é possível dividir $number1 por zero")
        }

        println(resultado)
    } catch (e: Exception) {
        println("Erro: ${e.message}")
    }
}