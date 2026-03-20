package aula_09_inicializacao_tardia

import kotlin.properties.Delegates

// um recruso que te permite declarar uma variavel posteriormente

fun main() {
    // lateinit

    lateinit var a: String

    // ...

    a = "kotlin"

    // lazy

    val b: String by lazy {
        "kotlin lazy"
    }

    println(a)
    println(b)

    // lateinit nao pode ser feito com variaveis de tipo primivito

    var c: Int by Delegates.notNull()

    c = 10

    println(c)
}