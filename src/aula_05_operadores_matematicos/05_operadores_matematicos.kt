package aula_05_operadores_matematicos

fun main() {
    // todos os basicos igual typescript


    // math

    val value = 2.9
    val valueRounded = Math.round(value)

    println(valueRounded)

    // vai sempre arredondar para baixo
    val valueFloor = Math.floor(value)
    println(valueFloor)

    // vai sempre arredondar o valor para cima
    val valueCeil = Math.ceil(value)
    println(valueCeil)


    // Math.pow é igual no javascript

    val logValue = Math.log10(100.0) // 10 * 10 = 100
    println(logValue)

    // os valores estao marcados porque a lib Math vem do java. basta apertar alt + enter que ele retorna a opção de converter para o nativo do kotlin
}