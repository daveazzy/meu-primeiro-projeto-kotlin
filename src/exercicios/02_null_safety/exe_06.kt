package exercicios.`02_null_safety`

fun somarSePositivo(a: Int?, b: Int?): Int {
    var soma: Int? = null
    if (a != null && b != null) {
        if (a < 0 || b < 0) return 0
    }

    if (a != null && b != null) {
        soma = a + b
    }

    return soma ?: 0
}

fun main() {
    var a: Int? = 2
    var b: Int? = 3

    println(somarSePositivo(a, b))
}