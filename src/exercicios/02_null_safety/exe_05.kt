package exercicios.`02_null_safety`

fun main () {
    val config: Map<String, String> = mapOf("tema" to "escuro")

    println(config["idioma"] ?: "pt-BR")
}