package exercicios.`07_herancas_interfaces`

abstract class Funcionario {
    abstract val nome: String
    abstract val salarioBase: Double

    abstract fun calcularSalario(): Double

    fun contracheque() {
        val salarioFinal = calcularSalario()
        println("""
            Nome: $nome
            Salario: $salarioFinal
        """.trimIndent())
    }
}

class FuncionarioClt(): Funcionario() {
    override val nome: String = "Mateus"
    override val salarioBase: Double = 3.500

    override fun calcularSalario(): Double {
        return salarioBase + salarioBase * 0.08
    }
}

class FuncionarioPj(): Funcionario() {
    override val nome: String = "Davidson"
    override val salarioBase: Double = 4.200

    override fun calcularSalario(): Double {
        return salarioBase
    }
}

class Estagiario(): Funcionario() {
    override val nome: String = "Maria"
    override val salarioBase: Double = 1.400

    override fun calcularSalario(): Double {
        return salarioBase
    }
}

fun main () {
    val clt = FuncionarioClt()
    val pj = FuncionarioPj()
    val estagiario = Estagiario()

    clt.contracheque()
    pj.contracheque()
    estagiario.contracheque()
}