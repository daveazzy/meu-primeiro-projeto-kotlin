package exercicios.`05_funcoes`

fun duplicar(n: Int) = n * 2
fun ehPositivo(n: Int) = n > 0

fun main() {
    val lista = listOf(5, 4, 2, 14, 35, 37, 24)

    val listaInt = lista.filterIsInstance<Int>()

    val filtro = meuFilter(listaInt, ::ehPositivo)
    val resultado = meuMap(listaInt, ::duplicar)

    println("Filtro (positivos): $filtro")
    println("Map (duplicados): $resultado")
}