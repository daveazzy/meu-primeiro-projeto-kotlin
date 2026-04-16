package exercicios.`03_colecoes`

fun main () {
    val diasSemana: Array<String> = arrayOf("Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado")
    println(diasSemana.joinToString(
        prefix = "Dias: ",
        postfix = ".",
        separator = " | "
    ))
}