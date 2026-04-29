package exercicios.`06_classes`

class Pilha<T> {
    private val items: MutableList<T> = mutableListOf()

    fun push (item: T) {
        items.add(item)
    }

    fun pop(): T? {
        return if (items.isNotEmpty()) items.removeLast() else null
    }

    fun peek(): T? {
        return if (items.isNotEmpty()) items.last() else null
    }

    fun estaVazia(): Boolean {
        return items.isEmpty()
    }

    fun tamanho(): Int {
        return items.size
    }
}

fun main () {
    val pilha = Pilha<Int>()
    pilha.push(1)
    pilha.push(2)
    pilha.push(3)

    println(pilha.peek())

    pilha.pop()
    println(pilha.peek())

    println(pilha.estaVazia())
    println(pilha.tamanho())

}