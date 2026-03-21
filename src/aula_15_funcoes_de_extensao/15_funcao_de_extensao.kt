package aula_15_funcoes_de_extensao

fun String.isPalindrome(): Boolean {
    return this == this.reversed()
}

fun Double.format(decimalDigits: Int) : String {
    return "%.${decimalDigits}f".format(this)
}

fun main() {
    println("radar".isPalindrome())
    println("banana".isPalindrome())

    println(3.14159.format(decimalDigits = 2))
}