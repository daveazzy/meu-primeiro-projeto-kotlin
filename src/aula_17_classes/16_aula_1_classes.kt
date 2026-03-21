package aula_17_classes

import kotlin.random.Random

class Person (val name: String = "Desconhecido", val lastName: String = "",val age: Int = 0) { // eu posso colocar valor inicial ou nao

    val fullName = "$name $lastName"

    // eu nao consigo acessar fora o escopo
    private val password: String = name + Random.nextInt(100) // metodos privados
    private fun usePassword(){
        println(password)
    }

    fun work() {
        usePassword()
        println("$fullName is working")
    }
}
fun main () {
    val jose: Person = Person("Jose", "Silva",28)

    println(jose)
    jose.work()

    val desconhecido: Person = Person()

    desconhecido.work()
}