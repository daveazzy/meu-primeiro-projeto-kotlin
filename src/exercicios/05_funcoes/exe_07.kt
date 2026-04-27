package exercicios.`05_funcoes`

fun main () {
    val lista: List<(Int) -> Int> = listOf(
        { x -> x * 2 },
        { x -> x * 3 },
        { x -> x + 10},
        { x -> x * x}
    )

    val listaInf = listOf(5, 5, 5, 5, 5)

}