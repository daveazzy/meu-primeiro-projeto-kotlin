package exercicios.`05_funcoes`

fun fatorial(n: Int): Long {
    var soma: Long = 1

    for (i in 1..n){
        soma *= i.toLong()
    }

    return soma
}

fun main () {
    // lembrete: !! força o kotlin a entender que ele nao eh null
    print("Digite um numero: ")
    val numero: Int = readLine()!!.toInt()

    println(fatorial(numero))
}