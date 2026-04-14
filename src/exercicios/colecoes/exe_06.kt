package exercicios.colecoes

fun main () {
    val list: List<Int> = listOf(3, 7, 2, 9, 1, 5, 8, 4, 6)

    println(list.find { it > 5 })
    println(list.findLast { it < 5})

    println(list.all { it % 2 == 0})
    println(list.any { it > 8})
    println(list.count { it > 4})
}