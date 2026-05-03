package exercicios.`06_classes`

open class Veiculo(open val marca: String, open val modelo: String, open val velocidadeMaxima: Double) {
    open fun descrever() {
        println("Marca: $marca")
        println("Modelo: $modelo")
        println("Velocidade: $velocidadeMaxima")
    }
}

class Carro (
    override val marca: String,
    override val modelo: String,
    override val velocidadeMaxima: Double,
    val numeroPortas: Int
) : Veiculo(marca, modelo, velocidadeMaxima) {
    override fun descrever() {
        println("Eu sou um carro da marca $marca, modelo $modelo, velocidadeMaxima $velocidadeMaxima e tenho $numeroPortas portas!")
    }
}

class CarroEletrico (
    override val marca: String,
    override val modelo: String,
    override val velocidadeMaxima: Double,
    val autonomiaKm: Double
): Veiculo(marca, modelo, velocidadeMaxima) {
    override fun descrever() {
        super.descrever()
        println("Sou elétrico. Minha autonomia é de $autonomiaKm km!")
    }
}

class Moto (
    override val marca: String,
    override val modelo: String,
    override val velocidadeMaxima: Double,
    val temSidecar: Boolean = false
): Veiculo(marca, modelo, velocidadeMaxima) {
    override fun descrever() {
        super.descrever()
        if (temSidecar) println("Tenho sidecar") else println("Não tenho sidecar")
    }
}

fun main() {
    val carro = Carro("Toyota", "Corolla", 180.0, 4)
    carro.descrever()

    val eletrico = CarroEletrico("Tesla", "Model 3", 200.0, 500.0)
    eletrico.descrever()

    val moto = Moto("Harley", "Street 750", 190.0, true)
    moto.descrever()
}