package aula_17_classes
// classes que sao declaradas dentro do escopo de uma outra class

class Car(val model: String, val year: Int){
    class Engine {
        class FuelType(val name: String){
            fun fuelCar() {
                println("$name is FuelType")
            }
        }

        fun start() {
            println("Car started")
        }
    }
}

fun main () {
    val car = Car("Honda Fit", 2018)

    val carEngine = Car.Engine()

    val fuelType = Car.Engine.FuelType("Gasolina")

    println(car)
    println(carEngine)
    println(fuelType)
}
