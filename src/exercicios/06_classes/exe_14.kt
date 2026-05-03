package exercicios.`06_classes`

data class Pessoa(val nome: String, val idade: Int)
class PessoaNormal(val nome: String, val idade: Int)

fun main() {
    // Data class
    val p1 = Pessoa("Dave", 25)
    val p2 = Pessoa("Dave", 25)

    println(p1 == p2)   // true (valores iguais)
    println(p1 === p2)  // false (objetos diferentes)

    // Classe normal
    val pn1 = PessoaNormal("Dave", 25)
    val pn2 = PessoaNormal("Dave", 25)

    println(pn1 == pn2)  // false (classe normal não tem equals gerado)
    println(pn1 === pn2) // false (objetos diferentes)

    // Mesma referência
    val p3 = p1
    println(p1 === p3)   // true (mesma instância)
}