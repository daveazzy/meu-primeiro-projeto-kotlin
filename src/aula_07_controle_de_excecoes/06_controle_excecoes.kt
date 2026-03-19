package aula_07_controle_de_excecoes

fun main() {
    // famoso try catch
    // tudo MUITO similar ao javascript

    var x = 1

    try {
        x = 2 / 0 // -> erro matematico. vai cair no catch
        println(x)
    } catch (error: Exception) {
        x = 3
        println(error.message) // no console teremos um erro de divisão por zero
    }

    println(x)

    // ainda temos o finally

    // -----------------------

    var y = 2

    try {
        y = 3 / 0
    } catch (err: ArithmeticException) {
        println("Erro de expressão aritmética.")
    } catch (err: Exception) {
        println("Erro genérico.")
    } finally {
        println("Aqui temos o finally.")
    }
}