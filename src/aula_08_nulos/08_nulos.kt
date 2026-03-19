package aula_08_nulos

fun main() {
    var a: String? = null // interrogação como em typescript
    val result: String = a ?: "kotlin"

    println(result)

    // ------------------------------------------

    // operador de chamadas seguras
    println("Operador de chamadas seguras")

    var b: Int = -1

    b = a?.toInt() ?: 0

    println(b)


    //  operador de asserção não nula
    // converter tipos possivelmente nulos par aum tipo que nao via ser nulo. ele é perigoso, pois aquele operador vai definir que o valor nao vai ser nulo

    a = "1"
    if(a != null) {
        println(a!!.toInt())
    }

    // safe guest
    // ele vai nos proteger no momento de converter um tipo de dado para outro

    val c = a as? Int

    println(c)

    // função let
    // executa um bloco de codigo apenas se o valor nao for nulo

    b?.let {
        println(it) // it contem o valor de b nao nulo dentro do escopo do let
    }
}