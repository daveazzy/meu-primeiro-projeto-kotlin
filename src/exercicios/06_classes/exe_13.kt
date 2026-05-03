package exercicios.`06_classes`

data class Produto (
    val id: Int,
    val nome: String,
    val preco: Double,
    val categoria: String
)

fun main () {
    val produto1 = Produto(1, "Camisa do flamengo", 370.00, "Roupa")
    val produto2 = Produto(2, "Xícara", 39.90, "Utilidades")
    val produto3 = Produto(3, "Colchão", 299.90, "Utilidades")
    val produto4 = Produto(4, "Monitor Gamer", 799.90, "Gamer")
    val produto5 = Produto(5, "Mousepad", 129.90, "Informática")

    val listaProdutos = mutableListOf(produto1, produto2, produto3, produto4, produto5)

    var maisCaro: Produto? = null
    var precoMaximo: Double = 0.0
    for ((id, nome, preco, categoria) in listaProdutos) {
        if (preco > precoMaximo) {
            precoMaximo = preco
            maisCaro = Produto(id, nome, preco, categoria)
        }
    }

    val desconto: Double = maisCaro!!.preco.times(0.10)
    val maisCaroComDesconto = maisCaro.copy(preco = maisCaro.preco - desconto)

    println(maisCaroComDesconto)
}