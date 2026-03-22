package aula_17_classes

class User(val name: String, val age: Int)

// uma data class precisa ter ao menos uma propriedade para poder existir
data class UserDataClass(val name: String, val age: Int)

fun main() {
    val user = User("Alice", 29)
    val userDataClass = UserDataClass("Alice 2", 29)


    // toString
    println(user.toString())
    println(userDataClass.toString())

    // equals
    // ele sempre compara cada dado

    val jose = UserDataClass("Jose", 25)
    val maria = UserDataClass("Maria", 27)

    val jose2 = UserDataClass("Jose", 25)

    println(jose == maria)
    println(jose2 == jose)

    // quando a classe nao eh user class, o compilador compara o endereço de memoria, e nao cada dado
    val user2 = User("Alice", 29)
    println(user2 == user)

    // copy - existe apenas nas data class

    val copyMaria = maria.copy()
    println(copyMaria.toString())

    val copyJose = jose.copy(age = 50)
    println(copyJose.toString())

    // desestruturando a instqancia de jose
    val (name, age) = jose
    println("$name, $age")

    val (x, y) = maria // -> posso chamar de qualquer coisa
    println("$x, $y")
}