package aula_20_classes_seladas

// essas classes e interfaces vão restrignir a hierarquia de subclasses
// palavra chave - controle sobre a herança

sealed class Result { // estado
    // sub estados
    //                                             se usa os parenteses porque está instanciando
    data class Success (val data: String) : Result()
    data class Error (val exception: Exception): Result()
    data object Loading : Result()


}

fun handleResult(result: Result){
    println(
        when(result){
            is Result.Error -> "Houve um erro! ${result.exception.message}"
            Result.Loading -> "Carregando"
            is Result.Success -> "Sucesso! ${result.data}"
        }
    )
}

object Database {
    fun getContacts (): Result {
        return Result.Success(data = listOf("Joao", "Jose", "Maria").joinToString())
    }

    fun insertContact(contact: String): Result {
        return Result.Error(exception = IllegalArgumentException("O contato a ser inserido possui caracteres invalidos"))
    }
}

//interface selada
sealed interface Animal {
    data class Dog(val breed: String) : Animal {
        // acessando x e mudando seu valor apenas para cachorro
        override val x: Int
            get() = super.x * 2

        override fun sound(): String {
            return "au au"
        }
    }

    data class Cat(val color: String): Animal {
        override fun sound(): String {
            return "miau"
        }
    }

    fun sound(): String
    val x: Int
        get() = 10
}
fun main () {
    val contacts: Result = Database.getContacts()
    val isContactInserted: Result = Database.insertContact("Joao")

    handleResult(contacts)
    handleResult(isContactInserted)
}

