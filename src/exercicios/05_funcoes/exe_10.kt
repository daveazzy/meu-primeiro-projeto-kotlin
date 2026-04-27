package exercicios.`05_funcoes`

fun <T, R> meuMap(lista: List<T>, transformacao: ((T) -> R)): List<R> {
    var listaFinal = mutableListOf<R>()

    for (i in lista){
        listaFinal.add(transformacao(i))
    }

    return listaFinal
}

fun main () {
    val lista = listOf(1,2,3,4,5)

    val resultado = meuMap(lista, {it -> it * 2 })
    println(resultado)
}