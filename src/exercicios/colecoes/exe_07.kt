package exercicios.colecoes

fun main () {
    val lista = listOf("Ana", "Bruno", "Carlos", "Amanda", "Daniel")


    println(lista.sorted())

    val sortedList = lista.sorted()
    println(sortedList.mapIndexed { i, v -> "${i+1}. $v" })
}