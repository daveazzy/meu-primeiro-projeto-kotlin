package exercicios.`02_null_safety`

fun main () {
    val lista = listOf<Any>(1, "dois", 3.0, "quatro", 5)

    for (i in lista) {
        println(i as? String)
    }
}