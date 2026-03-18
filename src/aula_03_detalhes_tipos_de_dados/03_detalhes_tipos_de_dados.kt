package aula_03_detalhes_tipos_de_dados

fun main() {

    val age: Int = 20

    // basicamente todos os tipos de dado é uma classe. entao cada um tem seu metodos

    // adicionar meses em formato decimal ao inteiro da idade (converter idade em um topo de dado numerico flutuante)
    var ageDouble: Double = age.toDouble()

    val monthPercent: Double = 1.0 / 12

    println("ageDouble = $ageDouble | monthPercent = $monthPercent")

    // se passaram 2 meses

    ageDouble += 2 * monthPercent

    println("ageDouble = $ageDouble")

    // agora vamos mostrar a idade com o formato string com o padrão "a idade é X anos"

    val ageText: String = "A idade é " + ageDouble.toString().plus(" anos.") // -> o metodo plus é de strings, e serve para adicionar uma string ao final do valor

    println(ageText)


    // convertendo para letras maiusculas

    println(ageText.uppercase())
}