package exercicios.`06_classes`

class Temperatura () {
    var celsius: Double = 0.0
        set(value) {
            require(value >= -273.15) {"Nao pode ser menor que o zero absoluto"}
            field = value
        }

    val fahrenheit: Double
        get() =celsius * (9 / 5) + 32.0

    val kelvin: Double
        get() = celsius + 273.15
}

fun main () {
    val temperatura = Temperatura()

    temperatura.celsius = 32.0
    println(temperatura.fahrenheit)
    println(temperatura.kelvin)
}