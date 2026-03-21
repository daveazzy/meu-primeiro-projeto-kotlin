package aula_10_colecoes

fun main() {
    // set vai gera ruma coleççao de elementos unicos. ele nao permite numeros duplicados e nao permite o acesso ao indice direto

    val set = setOf(1, 2, 3, 2)

    val setRandom = setOf(1,2, 3, "kotlin", "kotlin", 4.0, 5f, 0..100, 1 ,2 , 19, "kotlin2")

    println(set)
    println(setRandom)

    val mutableSet = mutableSetOf(1,2,3)

    println(mutableSet)

    mutableSet.remove(1)
    println(mutableSet)

    // map conhecido como dicionario
    val map = mapOf(Pair(1, "Kotlin"), 1 to "Kotlin", 2 to "Java", 3 to "typescript") // o primeiro pair foi utilizado, mas o segundo foi descartado por ter a mesma chave
    println(map)

    // sempre o ultimo vai sobrescrever o primeiro em caso de duplicaão

    // aqui conseguimos pegar as chaves, valores e entries

    println(map.keys)
    println(map.values)
    println(map.entries)

    val mutableMap = mutableMapOf(1 to "Kotlin", "Java" to 1, 1f to 1.0, 0..10 to 2) // posso colocar qualquer tipo de valor que ele nao vai reclamar
    println(mutableMap)

    // os metodos sao basicamente os mesmo para todas as colecoes
}