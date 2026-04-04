package exercicios.`02_null_safety`

fun main () {
    // aceitavel
    var name: String? = "Davidson"
    var length: Int? = null
    if (name != null) {
        length = name!!.length
    }

    // perigoso
    var nome: String? = null
    var texto: Int? = nome!!.length

    println(length)
    println(texto)
}