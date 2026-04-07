package exercicios.colecoes

fun main () {
    val lista = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    var count = 0
    while (count < lista.size) {
        if (lista[count] % 2 == 0) {
            lista.removeAt(count)
        }
        else {
            count ++
        }
    }

    println(lista.joinToString())
}