package exercicios.`06_classes`

class Fracao(val numerador: Int, val denominador: Int) {
    init {
        require(denominador != 0) {"Cannot be 0"}
    }

    companion object {
        fun inteiro(number: Int): Int {
            return number
        }

        fun metade (number: Int): Int {
            return number / 2
        }

        fun umTerco(number: Int): Int {
            return number / 3
        }
    }

    private fun mdc (numerador: Int, denominador: Int): Int {
        return if (denominador == 0) numerador else mdc(denominador, numerador % denominador)
    }

    fun simplificar (): Fracao {
        val mdc = mdc(numerador, denominador)
        return Fracao(numerador / mdc, denominador / mdc)
    }

    override fun toString(): String {
        return "$numerador / $denominador"
    }
}

fun main () {
    val inteiro = Fracao.inteiro(6)
    println(inteiro)

    val metade = Fracao.metade(6)
    println(metade)

    val umTerco = Fracao.umTerco(6)
    println(umTerco)

    val fracao = Fracao(100, 50)

    println(fracao.simplificar())
    println(fracao.toString())
    println(fracao.simplificar().toString())
}