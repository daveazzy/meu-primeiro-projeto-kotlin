package aula_21_generics

// vão permitir que voce escreva um codigo que sejam dependentes do tipo especifico que voce ta criando

fun <T> printItem (item: T) {
    println(item)
}

class Container <T>(val items: List<T>): ItemsPrinter<T> {
    fun showItems() {
        println(
            """
                Itens do container:
                ${items.joinToString("\n")}
            """.trimIndent()
        )
    }

    override fun printItem(item: T) {
        println("Item: $item")
    }
}

data class Product(val name: String, val amount: Int)

interface ItemsPrinter<T> {
    fun printItem(item: T)
}

fun <T> List<T>.secondeOrNull(): T? {
    return if (this.size >= 2) this[1] else null
}

fun <T: Comparable<T>> findMax(a: T, b: T): T {
    return if (a > b) a else b
}

fun main() {
    printItem("Kotlin")
    printItem(true)
    printItem(1)
    printItem(object {
        val name: String = "Hello"
        val x: Double = 100.0
    })

    val container1 = Container(listOf(
        Product("Laranja", 10),
        Product("Maçã", 20)
    ))

    container1.showItems()

    val container2 = Container(listOf(
        "Laranja",
        "Maçã"
    ))

    container2.showItems()
    container2.printItem(container2.items.first())

    val product1 = listOf(
        Product("Laranja", 10),
        Product("Maçã", 20)
    )

    val product2 = listOf(Product("Laranja", 10))

    println(product1.secondeOrNull())
    println(product2.secondeOrNull())

    println(findMax("Hello", "Kotlin"))
    println(findMax(10, 100))
}