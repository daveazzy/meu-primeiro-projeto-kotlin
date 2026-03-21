package aula_10_colecoes

fun main() {
    // parecido com array porem
    // uma lista pode receber adições de novos valores a qualquer momento se ela é mutavel

    val list = listOf(1, 2, 3) // lista fixa
    val mutableList = mutableListOf(1, 2, 3) // pode adicionar ou remover itens a qualquer moemnto

    mutableList.add(4)

    println(list)
    println(mutableList)

    // conseguimos colocar varios tipos de dados em uma lista
    val list2 = listOf(1, 2, 3, "4", false, 1..3, 4.0, 10, 20)
    println(list2)


    // principais metodos das listas
    val listInt: List<Int> = list2.filterIsInstance<Int>() // ele vai pegar apenas os tipso inteiros

    println(listInt)

    val listIntHigherThan2: List<Int> = list.filter{it is Int && it > 2}
    println(listIntHigherThan2)

    val listIntMessy = listOf(9, 10, 70, 1, 3, 750, 8, 16, 32_550, 2)

    println(listIntMessy.sorted()) // sorted ordena todos os itens. no caso de strings, a ordem que segue eh a alfabetica

    println(listIntMessy.sortedDescending())
    println(listIntMessy.reversed())


    // formas de se encontrar elementos em listas
    val intMax = listIntMessy.max()
    val intMin = listIntMessy.min()

    println(intMax)
    println(intMin)

    val findFirstOdd = list.find { it is Int && it % 2 == 1} // encontrar primeiro impar
    println(findFirstOdd)

    val findLastOdd = list.findLast { it is Int && it % 2 == 1}
    println(findLastOdd)

    // metodo map
    val booleanMapIntHigherThan10 = listIntMessy.map{ it > 10 }
    println(booleanMapIntHigherThan10)

    // outros métodos importantes...

    println(list.first())
    println(list.last())
    println(list.subList(0, 3))
    println(list[3])
    println(list.indexOf(4))
    println(list.indices)
    println(list.size)
    println(list.isEmpty())
    println(list.isNotEmpty())
    println(list.drop(2))
    println(list.dropLast(2))
    println(list.dropWhile { it is Int })
    println(listInt.any { it < 0 })
    // println(listStringMessy.any { it.startsWith("Z") })
    println(list.all { it is Int })
    println(list.zip(listInt))
    println(list.elementAt(1))
    println(list.getOrNull(10))
    println(listInt.mapIndexed { index, item -> index + item })
}