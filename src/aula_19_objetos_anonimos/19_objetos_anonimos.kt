package aula_19_objetos_anonimos
// uma forma de voce criar instancias de classes sem a necessidade de declarar uma classe explicita
// adequado para criar classes que nao vao ser retutilizadas , como manipuladores de eventos

interface ClickCallback {
    fun onClick()
}

fun main () {
    val x = 10

    val objectTemp = object {
        val property1: Int = 1
        val property2: String = "Hello World"

        fun method1() {
            println("Método 1")

            // temos acesso ao escopo externo
            println(x)
        }
    }

    // a gente consegue ler as propriedades e metodos
    println(objectTemp.property1)
    println(objectTemp.property2)
    objectTemp.method1()

    val buttonClickCallback = object: ClickCallback {
        override fun onClick() {
            println("Botão clicado")
        }
    }

    buttonClickCallback.onClick()
}