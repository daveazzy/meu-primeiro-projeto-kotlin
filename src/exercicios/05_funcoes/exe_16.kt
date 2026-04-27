package exercicios.`05_funcoes`

fun Double.paraReal(): String {
    val pontoPorVirgula = this.toString().replace(".",",")
    val resultado = "R$ $pontoPorVirgula"

    return resultado
}

fun main () {
    println(1500.5.paraReal())
}