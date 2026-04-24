package exercicios.`04_lacos`

fun main () {
    print("Digite um número maior que 1: ")
    var input = readLine()

    var value: Int = input?.toInt() ?: 0


    var count = 0
    while (value != 1){
        if (value % 2 == 0) value /= 2
        else value = (3 * value) +1

        count++
    }


    println(count)
}