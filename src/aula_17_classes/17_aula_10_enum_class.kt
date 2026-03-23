package aula_17_classes

enum class Direction (val description: String) {
    NORTH("Direção norte"), // 0
    SOUTH("Direção sul"), // 1
    EAST("Direção leste"), // 2
    WEST("Direção oeste");// 3

    // podemos criar metodos
    fun addDirection(direction: Direction) {
        println(this.description)
        println(direction.description)
    }

    // caso o metodo nao precise do contexto de uma instancia (contexto estatico)
    companion object {
        fun sumDirection(firstDirection: Direction, secondDirection: Direction) {
            println("First ${firstDirection.description}")
            println("Second ${secondDirection.description}")
        }
    }

    // podemos criar metodos abstratos
    //abstract fun sumbol(): String

    // nesse caso, teria que impementar isso em NORTH, SOUTH, EAST e WEST
    // NORTH("Direção norte") {
    //     override fun symbol(): String {
    //      return "emoji"
    //     }
    //   }

    // tambem podemos ter propriedades abstratas
}

fun main () {
    val north = Direction.NORTH

    println(north.name)
    println(north.ordinal)

    println(Direction.EAST.description)

    north.addDirection(Direction.SOUTH)

    Direction.sumDirection(Direction.SOUTH, Direction.EAST)

    // entries
    Direction.entries.forEach {item ->
        println(item)
    }

    // valueOf
    println(Direction.valueOf("SOUTH").ordinal)
}