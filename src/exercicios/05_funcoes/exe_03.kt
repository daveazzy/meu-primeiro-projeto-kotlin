package exercicios.`05_funcoes`

fun saudar(name: String, saudacao: String = "Olá", pontuacao: String = "!"): String {
    return "$saudacao, $name $pontuacao"
}

fun main () {
    print("Digite: ")
    val name = readLine().toString()

    val saudacao: String = saudar(name)
    println(saudacao)
}