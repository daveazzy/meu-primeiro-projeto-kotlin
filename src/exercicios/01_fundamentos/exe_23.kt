package exercicios.`01_fundamentos`

fun main () {
    var a = readln().toInt()
    var b = readln().toInt()

    fun dividir(a: Int, b: Int): Double {
        if (b == 0) throw IllegalArgumentException("Não é possível dividir $a por 0")

        return a / b.toDouble()
    }

    println(dividir(a, b))
}