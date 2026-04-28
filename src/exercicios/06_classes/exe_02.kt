package exercicios.`06_classes`

import kotlin.random.Random
// construtores secundarios servem para deixar a matricula opcional
class Aluno (val nome: String, var matricula: String) {
    constructor(nome: String): this(nome, "$nome-${Random.nextInt(1000, 9999)}")

    val notas: MutableList<Double> = mutableListOf()

    fun getAluno () {
        println(nome)
        println(matricula)
    }

    fun adicionarNotas(nota: Double) {
        if (nota in 0.0..10.0) notas.add(nota)
        else println("Nota inválida. Ela deve estar entra 0 e 10.")
    }

    fun media(): Double {
        val soma = notas.sum()
        return soma / notas.size
    }

    fun situacao (): String {
        val media = media()

        if (media >= 6) return "Aprovado"
        else if (media in 3.0..<6.0) return "Recuperação"
        else return "Reprovado"
    }
}

fun main () {
    val aluno = Aluno("Davidson")

    aluno.getAluno()
    aluno.adicionarNotas(6.0)
    aluno.adicionarNotas(10.0)
    aluno.adicionarNotas(10.0)

    println(aluno.media())
    println(aluno.situacao())
}