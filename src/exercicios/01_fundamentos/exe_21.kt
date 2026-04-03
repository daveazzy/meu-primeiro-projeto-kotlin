package exercicios.`01_fundamentos`

fun main () {
    fun descreverTipo (something: Any): String = when (something) {
        is String -> "Texto: $something"
        is Float -> "Float: $something"
        is Double -> "Double: $something"
        is Boolean -> "Boolean: $something"
        is Int -> "Int: $something"
        else -> "Tipo desconhecido"
    }

    val qualquerCoisa = 7.0

    println(descreverTipo(qualquerCoisa))
}