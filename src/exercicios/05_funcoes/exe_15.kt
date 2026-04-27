package exercicios.`05_funcoes`

fun List<Int>.estatisticas(): List<Double> {
    var lista = mutableListOf<Double>()

    var tamanho = this.size
    lista.add(tamanho.toDouble())

    var soma = this.sum()
    lista.add(soma.toDouble())

    var media = soma / tamanho
    lista.add(media.toDouble())

    var min = 0
    for (i in this.indices) {
        if (i == 0) min = this[i]
        else if (this[i] < this[i - 1]) min = this[i]
    }

    lista.add(min.toDouble())

    var max = 0
    for (i in this.indices){
        if (i == 0) max = this[i]
        else if (this[i] > this[i - 1]) max = this[i]
    }

    lista.add(max.toDouble())

    return lista
}

fun main () {
    val lista: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    println(lista.estatisticas())
}