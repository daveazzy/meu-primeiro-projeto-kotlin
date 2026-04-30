package exercicios.`06_classes`

class Circulo() {
    var raio: Double = 0.0
        set (value) {
            if (value > 0) field = value
            else println("O circulo deve ter um raio maior que zero.")
        }

    val area: Double
        get() = 3.1415926535 * (raio * raio)

    val perimetro: Double
        get() = 2 * 3.1415926535 * raio

    val descrição: String
        get() = "Area: $area, Perimetro: $perimetro"
}

fun main () {
    val circulo = Circulo()

    circulo.raio = 3.0

    println(circulo.area)
    println(circulo.perimetro)
    println(circulo.descrição)
}