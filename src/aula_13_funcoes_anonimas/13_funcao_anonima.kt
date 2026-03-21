package aula_13_funcoes_anonimas

fun main() {
    // eh uma funcao que nao tem nome e pode ser definida em qualquer lugar onde uma experessão pode ser utilziada

    val funSum = { a: Int, b: Int -> a + b }

    println(funSum(1, 2))

    // elas nao podem alterar valores de uma variavel
    var sum = 2 + 2
    val funSum2 = { a: Int, b: Int -> {
        sum = 100
        a + b
        }
    }

    println(sum)

    // com o invoke eu consigo executar
    println(funSum2(1, 2).invoke())
    println(sum)
}