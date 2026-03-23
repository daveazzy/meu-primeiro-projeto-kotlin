package aula_17_classes

// contratos que a gente tem que cumprir de subclasses. sempre que a gente tem algo
// a ser extendido dentro do conceito de uma classe, nós temos que criar métodos de tudo que é abstrato
                      // podemos ter construtores
abstract class Vehicle(val color: String) {
    abstract val maxSpeed: Int
    abstract val wheelAmount: Int

    abstract fun startMovement ()

    // podemos ter tambem metodos concretos
    fun info() {
        println("""
            Velocidade Máxima: $maxSpeed Km / h
            Quantidade de rodas: $wheelAmount
        """.trimIndent())
    }
}

// veiculo passa a ser um contrato. toda classe que extender vehicle necessitará implementar essas propriedades e metodos

         // eu recebo uma cor ---> e depois a atribuo
class Siena(val model: String, val year: Int, color: String): Vehicle(color) {
    override val maxSpeed: Int
        get() = 150
    override val wheelAmount: Int
        get() = 4

    override fun startMovement() {
        println("Siena is running")
    }

    // nos vamos usar o override para sobrescrever o metodo que retorna a base de informação do veiculo
    override fun toString(): String {
        super.info()
        return model + ", " + year + ", " + color.toString()
    }
}

class Bike(color: String): Vehicle(color) {
    override val maxSpeed: Int
        get() = 30
    override val wheelAmount: Int
        get() = 2

    override fun startMovement() {
        println("Bike is running")
    }
}

fun main(){
    val newCar = Siena("Fiat Siena", 2019, "Preto")
    val newBike = Bike("Prata")

    println(newCar)

    println(newBike.maxSpeed)
    println(newBike.wheelAmount)
    newBike.startMovement()
    newBike.info()
}