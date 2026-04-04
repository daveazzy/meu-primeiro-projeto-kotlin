package exercicios.`01_fundamentos`

fun main () {
    print("Digite o seu peso: ")
    var peso = readln().toFloat()

    print("Digite a sua altura: ")
    var altura = readln().toFloat()

    val imc = peso / (altura * altura)
    if (imc < 18.5) println("Abaixo do peso: $peso")
    if (imc in 18.5 .. 24.9) println("Peso normal: $peso")
    if (imc in 25.0 .. 29.9) println("Sobrepeso: $peso")
    if (imc in 30.0 .. 34.9) println("Obesidade grau I: $peso")
    if (imc >= 35) println ("Obresidade grau II/III: $peso")
}