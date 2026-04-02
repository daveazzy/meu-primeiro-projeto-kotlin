package aula_22_variancia

// como os tipos genericos vao se comportar em relaçãop à herança dos tipos recebidos

open class Animal (val name: String)

class Dog: Animal(name = "Cachorro")
class Cat: Animal(name = "Gato")
class Bird: Animal(name = "Passaro")

// contravariancia = in (consumidores)
class Feeder<in T: Animal> {
    fun feed (animal: T) {
        println("${animal.name} foi alimentado")
    }
}

// covaricancia = out (produtores)

open class Drink(val name: String)

class Juice: Drink("Suco")
class Soda: Drink (name = "Refrigerante")
class Coffee : Drink(name = "Café")

class Cup<out T: Drink>(val drink: T, val amount: Int)

fun serveDrink(cup: Cup<Drink>) {
    println("Servindo a bebida ${cup.drink.name} de quantidade ${cup.amount}")
}

fun main () {
    Feeder<Cat>().feed(Cat())
    serveDrink(Cup<Coffee>(Coffee(), 100))

    // se a gente tenta servir um suco que não é da instancia suco dá problema
    serveDrink(Cup<Juice>(Juice(), 300))
}