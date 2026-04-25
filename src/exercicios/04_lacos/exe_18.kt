package exercicios.`04_lacos`

fun main () {

    var um = 0
    var dois = 0
    var tres = 0
    var quatro = 0
    var cinco = 0
    var seis = 0

    repeat(1000) {
        var dado = (1..6).random();

        if (dado == 1) um++
        else if (dado == 2) dois++
        else if (dado == 3) tres++
        else if (dado == 4) quatro++
        else if (dado == 5) cinco++
        else if (dado == 6) seis++
    }

    println(um)
    println(dois)
    println(tres)
    println(quatro)
    println(cinco)
    println(seis)
}