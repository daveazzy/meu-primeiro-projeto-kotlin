package exercicios.`04_lacos`

fun main () {
    val list = listOf("Kotlin", "Java", "Python", "Swift", "Go")

    list.forEachIndexed { index, value -> println("${index+1}. $value") }
}