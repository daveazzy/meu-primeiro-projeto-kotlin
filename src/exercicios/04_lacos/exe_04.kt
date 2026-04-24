package exercicios.`04_lacos`

fun main () {
    var string: String = ""
    for (i in 1..5){
        string = ""
        for (j in 1..i) {
            string += "*"
        }

        println(string)
    }
}