package exercicios.`06_classes`

class Senha () {
    var valor: String = ""
        set (value) {
            require(value.length >= 8) {"A senha deve conter no minimo 8 caracteres."}
            field = value
        }

    val retorno: String
        get () = "*".repeat(valor.length)

    fun verificar (tentativa: String): Boolean {
        return tentativa == valor
    }
}

fun main () {
    val senha = Senha()

    senha.valor = "davidson"
    println(senha.retorno)
    println(senha.verificar("senha"))
    println(senha.verificar("davidson"))

}