package exercicios.`01_fundamentos`

fun main () {
    var valor: String = "42"
    println(valor.toInt())

    var abc: String = "abc"
    println(abc.toInt())

    /*
    Exception in thread "main" java.lang.NumberFormatException: For input string: "abc"
    at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
    at java.base/java.lang.Integer.parseInt(Integer.java:662)
    at java.base/java.lang.Integer.parseInt(Integer.java:778)
    at exercicios.01_fundamentos.Exe_09Kt.main(exe_09.kt:8)
    at exercicios.01_fundamentos.Exe_09Kt.main(exe_09.kt)
    */
}