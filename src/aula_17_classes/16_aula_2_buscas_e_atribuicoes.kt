package aula_17_classes

// como personalizar os metodos get e set das propriedades das classes

class Person1(val name: String) {
    var age: Int = 0
    // precisa ser abaixo da variavel criada
        set(value) {
            if(value >= 0) field = value
            else println("Idade nao pode ser negativo")
        }

    var height: Double = 0.0
        get() = Math.ceil(field)
}


fun main() {
    val joao = Person1("Joao")

    joao.age = 30
    joao.height = 175.9

    println(joao.age)
    println(joao.height)

    joao.age = -1
}