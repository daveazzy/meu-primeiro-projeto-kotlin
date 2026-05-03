package exercicios.`06_classes`
// para reutilizar tudo do pai e adicionar mais coisas


open class Funcionario(val nome: String, val salario: Double) {
    open fun calcularBonus(): Double {
        return salario * 0.10  // 10% de bônus
    }
}

class Gerente(nome: String, salario: Double) : Funcionario(nome, salario) {
    override fun calcularBonus(): Double {
        return super.calcularBonus() + 500.0  // bônus do pai + 500 extra
    }
}


fun main () {
    val gerente = Gerente("Davidson", 5000.0)
    println(gerente.calcularBonus())  // (5000 * 0.10) + 500 = 1000
}
