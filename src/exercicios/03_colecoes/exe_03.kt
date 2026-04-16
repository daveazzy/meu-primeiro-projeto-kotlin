package exercicios.`03_colecoes`

fun main () {
    val array: Array<Int> = arrayOf(5, 3, 8, 1, 9, 2)

    for (j in 0 .. array.size) {
        for (i in 0.. array.size -2) {
            if (array[i] > array[i + 1]) {
                val aux = array[i]
                array[i] = array[i + 1]
                array[i + 1] = aux
            }
        }
    }

    println(array.joinToString(
        prefix = "{",
        postfix = "}",
        separator = ", ",
    ))
}