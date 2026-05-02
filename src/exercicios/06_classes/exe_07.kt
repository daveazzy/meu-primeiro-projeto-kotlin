package exercicios.`06_classes`

class IdGenerator {
    companion object {
        private var contador: Int = 0
    }

    fun gerar (): String {
        contador++
        return "ID-${contador}"
    }

    fun resetar (): Unit {
        contador = 0
        println(contador)
    }
}

fun main(){
    val geradorId1 = IdGenerator().gerar()
    println(geradorId1)

    val geradorId2 = IdGenerator().gerar()
    println(geradorId2)

    val reset = IdGenerator().resetar()
}