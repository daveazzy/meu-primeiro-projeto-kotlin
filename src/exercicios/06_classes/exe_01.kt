package exercicios.`06_classes`

class ContaBancaria (val titular: String, private var saldo: Double) {
    init {
        require(saldo >= 0) { "Saldo não pode ser negativo." }
    }

    fun depositar(valor: Double) {
        saldo += valor
    }

    fun sacar(valor: Double) {
        if (saldo >- valor) saldo -= valor
        else println("Saldo insuficiente.")
    }

    fun extrato  () {
        println("Titular: $titular")
        println("Saldo: $saldo")
    }
}

fun main () {
    val dave = ContaBancaria("Dave", 42.0)
    dave.depositar(5.0)
    dave.sacar(10.0)

    dave.extrato()
}