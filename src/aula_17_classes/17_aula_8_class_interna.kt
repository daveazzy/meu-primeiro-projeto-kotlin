package aula_17_classes

class Car1 (val model: String, val year: Int) {

    // a palavra inner é o que vai diferenciar. ela nao é aplicavel fora de uma classe, apenas interno
    inner class Engine {
        inner class Fuel(val typeName: String) {
            fun fuelCar () {
                println("$typeName is $year and it's fuelling")

                // tudo que está fora ou dentro do escopo da classe pode ser acessado
                start()
            }
        }

        fun start() {
            // aqui nos conseguimos acessar tanto model quanto year do carro
            println("$model, $year: I'm Running")
        }
    }
}

fun main() {
    //  val carEngine = Car1.Engine() ERRADO

    // como insatanciar classes internas
    val carEngine = Car1("Honda Fit", 2018).Engine()

    val carEngineFuelType = carEngine.Fuel("Gasolina")

    carEngine.start()
    carEngineFuelType.fuelCar()
}