package aula_11_lacos_de_repeticao

fun main() {

    loop@ for(i in 1..3) {
        for (j in 1..3){
            if(i == 2 && j == 2){
                break@loop
            }

            println("$i, $j")
        }
    }

    // repeat

    var index = 1
    repeat(5) {
        println(index)
        index++
    }

}