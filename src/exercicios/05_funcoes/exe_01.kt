package exercicios.`05_funcoes`

fun ehPalindromo (value: String): Boolean {
    value.toCharArray()

    if (value.reversed() == value){
        return true
    }

    return false
}
fun main () {
    print("Digite uma palavra para verificar se eh palimdromo: ")
    val string: String = readln()

    if(ehPalindromo(string)){
        println("$string eh palimdromo.")
    }
    else {
        println("$string não eh palindromo.")
    }
}