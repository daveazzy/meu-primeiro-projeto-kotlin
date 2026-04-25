package exercicios.`04_lacos`

fun main () {
    val matriz = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6),
        arrayOf(7, 8, 9)
    )

    label@ for (i in matriz.indices) {
        for (j in matriz[i].indices) {
            if (i == j) continue@label

            println("${matriz[i][j]} ")
        }
    }
}