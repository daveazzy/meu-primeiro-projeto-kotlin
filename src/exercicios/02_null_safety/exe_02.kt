package exercicios.`02_null_safety`

fun obterNome (id: Int): String? {
    var nome: String? = null

    if (id % 2 == 0) nome = "Davidson"
    if (id % 2 != 0) nome = null

    return nome
}

fun main () {
    val par: Int = 2
    val impar: Int = 3

    println(obterNome(par))
    println(obterNome(impar))
}