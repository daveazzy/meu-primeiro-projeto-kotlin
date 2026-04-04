package exercicios.`02_null_safety`

fun converterParaInt (obj: Any): Int? {
    return obj as? Int
}

fun main () {
    val valorTexto: Any = "10"
    val valorNumero: Any = 100
    val valorBoleano: Any = true

    println(converterParaInt(valorTexto))
    println(converterParaInt(valorNumero))
    println(converterParaInt(valorBoleano))
}