package aula_06_estruturas_concidionais


fun main() {
// if e else: mesma coisa como em javascript

// when


    val x = 100
    val y = 100

    val result = when (x) {
        in 1..100 -> "1..100" // ele sempre vai cair na primeira que foi atendida, mesmo que tenha mais de uma condição que satisfaz
        100 -> "100"
        in 101..100 -> "101"
        else -> "else"
    }

    println(result)
}
