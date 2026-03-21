package aula_11_lacos_de_repeticao

fun main() {
    // for

    val list = listOf(1,2,3, 5, 10)

    for (item in list) { // percorre a lista
        println(item)
    }

    list.forEach{
        item -> println(item)
    }

    list.forEach(::println)

    list.forEachIndexed { index, i ->
        println("index: $index, item: $i")
    }

    for((index, item) in list.withIndex()) {
        println("index: $index, item: $item")
    }

    // --------------

    println("While")

    // while

    var index = 1 // precisa ser mutavel
    val maxLimit = 5

    while (index < maxLimit) {
        println("index: $index ...")

        index++
    }

    // do while
    var index2 = 1

    do {
        println("index2: $index2 ...")
        index2++
    } while (index2 <= 5)

    // break e continue

    var index3 = 1

    do {
        println("index2: $index2 ...")

        if(index3 == 2) break

        index3++
    } while (index3 <= 5)

    for((index, item) in list.withIndex()) {
        if(index == 3) continue
        println("index: $index, item: $item")
    }
}