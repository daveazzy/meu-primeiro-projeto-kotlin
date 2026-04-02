package aula_23_funcao_inline_e_reified

// funcao inline = o corpo da funcao é inserido na aplicação onde é chamada
//      -> isso aumenta desempenho pois evita a sobrecarga de chamada de funcao

inline fun executeAction(action: () -> Unit) {
    println("execute action")
    action()
    println("finishing execute action")
}

// os tipos refied são usados em ufncoes genericas inlines
// se voce usa inline e refied, voce vai ter o poder de acessar o tipo generico dentro do bloco de codigo

inline fun <reified T> printTypeName () {
    println(T::class.simpleName)
}

// trazendo da aula anterior
open class Drink(val name: String)

class Juice: Drink("Suco")
class Soda: Drink (name = "Refrigerante")
class Coffee : Drink(name = "Café")

class Cup<out T: Drink>(val drink: T, val amount: Int)

// agora vamos colocar inline e reified aqui
inline fun <reified T: Drink>serveDrink(cup: Cup<T>) {
    // agora temos a capacidade de analisar qual é a classe do tipo T
    println("[${T::class.simpleName}] Servindo a bebida ${cup.drink.name} de quantidade ${cup.amount}")
}

fun main () {

    // a funcao inline vai basicamente fazer com que os prints da funcao sejam escritos aqui como se fosse manualmente
    executeAction {
        println("execute action")
    }

    printTypeName<String>()
    printTypeName<Int>()

    val juice = Juice()
    val juiceCup = Cup(juice, 500)

    serveDrink(juiceCup)
}