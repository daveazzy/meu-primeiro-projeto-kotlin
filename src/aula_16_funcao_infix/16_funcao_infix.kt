package aula_16_funcao_infix

// funcoes infix so podem ser definidas de membros (metodo) de uma classe ou de extensão

infix fun Int.sum(num: Int): Int = this + num

class XY(val x: Int, val y: Int){
    infix fun sum(xy: XY): XY {
        return XY(this.x + xy.x, this.y + xy.y)
    }
}

fun main() {
    println(1 sum 2)

    val xy = XY(2, 3) sum XY(4, 8)
    println(xy.x)
    println(xy.y)
}