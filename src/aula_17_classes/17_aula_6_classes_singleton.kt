package aula_17_classes
// uma unica instancia entregue para toda a aplicação

// nao pode alocar construtores
object DatabaseUtil {
    val url: String = "jdbc:postgresql://localhost:5432/postgres"
    val user: String = "admin"
    private val password: String = "admin"

    fun connect() {
        println("Connected to database $url | $user | $password")
    }
}

// eh parecido com data class
data object DatabaseHelper {

}

fun main(){
    DatabaseUtil.connect()

    println(DatabaseUtil)
    println(DatabaseHelper)
}
