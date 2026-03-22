package aula_17_classes
// uma forma de se definir membros estáticos para uma classe que nao vao pertencer às instancias, mas sim à classe

class Person3 {
    companion object {
        const val KEY = "12345678"
        private const val KEY_2 = "1234567890"

        fun getKey(): String {
            return KEY + KEY_2
        }
    }

    // private so pode ser usada aqui

    fun getKey(): String {
        return KEY_2
    }
}

fun main() {
    val key = Person3.KEY

    val jose = Person3()
    //jose.KEY // -> nao consigo acessar dessa maneira

    // nao eh possivel acessar diretamente a KEY_2
    // val key2 = Person3.KEY_2

    val obtainKey = Person3.getKey()
}