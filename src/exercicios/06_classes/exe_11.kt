package exercicios.`06_classes`

fun main () {
    val veiculos: List<Veiculo> = listOf(
        Carro("Toyota", "Corolla", 180.0, 4),
        CarroEletrico("Tesla", "Model 3", 200.0, 500.0),
        Moto("Harley", "Street 750", 190.0, true),
        Carro("Honda", "Civic", 190.0, 4),
        Moto("Yamaha", "MT-09", 220.0, false)
    )

    for (veiculo in veiculos) {
        veiculo.descrever()
    }
}