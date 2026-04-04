package exercicios.`02_null_safety`

fun nomeMaiusculo(nome: String?): String {
    return nome?.uppercase() ?: "ANÔNIMO"
}

fun main () {
    println(nomeMaiusculo("Davidson"))
}