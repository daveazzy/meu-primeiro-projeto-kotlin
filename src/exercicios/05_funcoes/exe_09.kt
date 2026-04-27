package exercicios.`05_funcoes`

fun <T> meuFilter (lista: List<T>, predicado: (T) -> Boolean): List<T>{
    var list = mutableListOf<T>()

    for (i in lista){
        if (predicado(i)) list.add(i)
    }

    return list
}

fun main () {
    val lista = listOf(5, 4, 2, 14, 35, "Davidson", "Oliveira", "ab", 37, 24)

    val filtro = meuFilter(lista, {it is Int && it % 2 == 0})
    val filtro2 = meuFilter(lista, {it is String && it.length > 3})

    println(filtro)
    println(filtro2)
}