package exercicios.`04_lacos`

fun main () {
    val precos = listOf(30, 20, 50, 56, 70, 34, 100, 99, 25)

    var soma = 0
    precos.forEach { numero ->
        if(numero >= 50) {
            soma += numero
        }
    }

    println(soma)
}