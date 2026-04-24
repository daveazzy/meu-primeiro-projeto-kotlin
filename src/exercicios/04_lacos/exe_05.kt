package exercicios.`04_lacos`

fun main () {
    val list = listOf("Kotlin", "Java", "Python", "Swift", "Go")

    for ((i, value) in list.withIndex()) {
        println("$i. $value")
    }
}