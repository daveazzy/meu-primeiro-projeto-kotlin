package aula_17_classes
// como implementar hierarquias dentro de uma classe

// para ser extendida para outras classes, precisa ter o nome open
open class Animal (val name: String = "Desconhecido") {
    open val age: Int = 0

    open fun sound() {
        println("$name is sound")
    }
}

class Dog(override val age: Int): Animal (name = "Cachorro") {
    override fun sound  () {
        println("$name is barking")
    }
}

fun main() {
    val dog = Dog(5)

    dog.sound()
    println(dog.age)
}
