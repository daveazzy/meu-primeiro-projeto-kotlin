package exercicios.`04_lacos`

fun main () {
    val matriz = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 8, 6),
        arrayOf(7, 8, 5)
    )

    // matriz.indices = 1..3 -> ele delimita para nao passar do intervalo
    external@ for (i in matriz.indices){
        for (j in matriz[i].indices) {
            if (matriz[i][j] == 5) {
                println("${matriz[i][j]} está na posição [$i][$j]")
                break@external
            }
        }
    }
}