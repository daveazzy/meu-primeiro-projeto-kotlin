package exercicios.`05_funcoes`

fun Int.ehPar(): Boolean {
    return this % 2 == 0
}
fun Int.ehImpar(): Boolean {
    return this % 2 != 0
}
fun Int.entre(min: Int, max: Int): Boolean {
    return this in min..max
}
fun Int.fatorial(): Long {
    var fat: Long = 1
    for (i in 1..this){
        fat *= i
    }

    return fat
}

fun main () {
    println(4.ehPar())
    println(5.ehImpar())
    println(4.entre(1, 5))
    println(5.fatorial())
}