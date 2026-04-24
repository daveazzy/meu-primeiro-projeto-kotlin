package exercicios.`04_lacos`

fun main () {
    print("1. Adicionar; 2. Listar; 3. Sair ")
    var input = readLine()

    var valueInput: Int = input?.toInt() ?: 0

    do {
        if (valueInput == 0) {
            print("Digite 1, 2 ou 3")
            input = readLine()

            valueInput = input?.toInt() ?: 0
        }

        if (valueInput == 1) {
            println("Adicionando")

            input = readLine()
            valueInput = input?.toInt() ?: 0
        } else if (valueInput == 2) {
            println("Listando")

            input = readLine()
            valueInput = input?.toInt() ?: 0
        }
    } while (valueInput != 3)
}