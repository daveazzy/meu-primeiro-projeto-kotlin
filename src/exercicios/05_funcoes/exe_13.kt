package exercicios.`05_funcoes`

import java.util.Locale

fun String.capitalizar(): String {
    val capitalizedText = this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
    return capitalizedText
}

fun String.contarPalavras(): Int {
    val separar = this.split(" ")
    return separar.size
}

fun String.inverter(): String {
    val invertedText = this.reversed()
    return invertedText
}

fun main () {
    println("davidson".capitalizar())
    println("Davidson Nunes de Oliveira".contarPalavras())
    println("davidson".inverter())
}