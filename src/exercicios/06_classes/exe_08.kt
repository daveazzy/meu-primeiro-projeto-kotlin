package exercicios.`06_classes`

class Configuracao {
    companion object {
        const val VERSAO = "1.0.0"
        var modoDebug: Boolean = false
        var urlBse: String = "http://192.168.0.104:8080"

        fun carregar (arquivo: String) {
            println("carregar: $arquivo")
        }
    }
}

fun main () {
    println(Configuracao.VERSAO)
    Configuracao.modoDebug = true
    Configuracao.carregar("config.json")
}