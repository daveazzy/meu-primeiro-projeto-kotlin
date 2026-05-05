package exercicios.`06_classes`

object Logger {
    val INFO: String = "Info"
    val WARNING: String = "Warning"
    val ERROR: String = "Error"

    var ativo: Boolean = true

    private val historico = mutableListOf<String>()

    fun info() {
        if (ativo) {
            val log = INFO
            historico.add(log)
        }
    }

    fun warning() {
        if (!ativo) {
            val log = "$WARNING: sistema inativo"
            historico.add(log)
        }
    }

    fun error() {
        if (ativo) {
            val log = ERROR
            historico.add(log)
        }
    }

    fun log (): List<String> {
        return historico
    }
}

fun main () {
    Logger.info()

    Logger.ativo = false
    Logger.warning()

    Logger.ativo = true
    Logger.error()

    println(Logger.log())
}