# Herança, Interfaces e Polimorfismo

## 1. Classes Abstratas

Não podem ser instanciadas diretamente. Definem um contrato que subclasses **devem** implementar.

```kotlin
abstract class Forma {
    abstract val nome: String
    abstract fun area(): Double
    abstract fun perimetro(): Double

    // Método concreto — disponível para todas as subclasses
    fun descrever() {
        println("$nome | Área: ${"%.2f".format(area())} | Perímetro: ${"%.2f".format(perimetro())}")
    }
}

class Retangulo(val largura: Double, val altura: Double) : Forma() {
    override val nome = "Retângulo"
    override fun area() = largura * altura
    override fun perimetro() = 2 * (largura + altura)
}

class Circulo(val raio: Double) : Forma() {
    override val nome = "Círculo"
    override fun area() = Math.PI * raio * raio
    override fun perimetro() = 2 * Math.PI * raio
}

val formas: List<Forma> = listOf(Retangulo(4.0, 5.0), Circulo(3.0))
formas.forEach { it.descrever() }
```

### Abstract vs open
| Aspecto              | `abstract`                    | `open`                        |
|----------------------|-------------------------------|-------------------------------|
| Instanciável         | Não                           | Sim                           |
| Membros abstratos    | Pode ter                      | Não pode                      |
| Herança obrigatória  | Sim (para uso)                | Opcional                      |

---

## 2. Interfaces

Definem contratos. Uma classe pode implementar **múltiplas** interfaces (Kotlin resolve o problema do diamante do Java).

```kotlin
interface Voador {
    fun voar()
    val altitudeMaxima: Int   // propriedade abstrata
}

interface Nadador {
    fun nadar()
    fun respirarNaAgua() = println("Usando brânquias")  // implementação padrão
}

class Pato : Voador, Nadador {
    override val altitudeMaxima = 100
    override fun voar() = println("Pato voando baixo")
    override fun nadar() = println("Pato nadando")
}
```

### Interface com implementação padrão
```kotlin
interface Logger {
    fun log(mensagem: String)   // abstrato — deve implementar

    fun info(mensagem: String) = log("[INFO] $mensagem")
    fun erro(mensagem: String) = log("[ERRO] $mensagem")
    fun debug(mensagem: String) = log("[DEBUG] $mensagem")
}

class LoggerConsole : Logger {
    override fun log(mensagem: String) = println(mensagem)
}

val logger = LoggerConsole()
logger.info("Aplicação iniciada")
logger.erro("Falha na conexão")
```

### Conflito de implementações padrão
```kotlin
interface A {
    fun metodo() = println("A")
}

interface B {
    fun metodo() = println("B")
}

class C : A, B {
    override fun metodo() {
        super<A>.metodo()   // resolve ambiguidade chamando A
        super<B>.metodo()   // e B
    }
}
```

### Interface vs Classe Abstrata

| Aspecto                    | Interface                    | Classe Abstrata              |
|----------------------------|------------------------------|------------------------------|
| Herança múltipla           | Sim                          | Não (só uma)                 |
| Estado (propriedades)      | Apenas abstratas/val         | Pode ter estado real         |
| Construtores               | Não                          | Sim                          |
| Modificadores de visibilidade | Apenas public             | Qualquer                     |
| Use quando                 | Capacidade/comportamento     | Base compartilhada de estado |

---

## 3. Objetos Anônimos

Cria uma instância de objeto sem nome de classe, implementando uma interface ou estendendo uma classe:

```kotlin
interface Botao {
    fun clicar()
}

// Cria objeto que implementa a interface on-the-fly
val botaoOk = object : Botao {
    override fun clicar() {
        println("Botão OK clicado!")
    }
}

botaoOk.clicar()
```

### Objeto anônimo com estado
```kotlin
val contador = object {
    var cliques = 0
    fun incrementar() = cliques++
    fun valor() = cliques
}

contador.incrementar()
contador.incrementar()
println(contador.valor())   // 2
```

### Objeto anônimo estendendo classe + interface
```kotlin
abstract class Animal(val nome: String) {
    abstract fun som(): String
}

interface Domestico {
    fun nomeDono(): String
}

val pet = object : Animal("Bolinha"), Domestico {
    override fun som() = "Au!"
    override fun nomeDono() = "Davidson"
}
```

---

## 4. Enum Classes

Conjunto fechado de constantes com comportamento:

```kotlin
enum class DiaSemana(val abreviacao: String, val ehUtil: Boolean) {
    SEGUNDA("Seg", true),
    TERCA("Ter", true),
    QUARTA("Qua", true),
    QUINTA("Qui", true),
    SEXTA("Sex", true),
    SABADO("Sab", false),
    DOMINGO("Dom", false);   // ponto-e-vírgula antes de membros

    fun proximo(): DiaSemana {
        val todos = entries
        return todos[(ordinal + 1) % todos.size]
    }
}

val hoje = DiaSemana.SEGUNDA
println(hoje.name)          // SEGUNDA
println(hoje.ordinal)       // 0
println(hoje.abreviacao)    // Seg
println(hoje.ehUtil)        // true
println(hoje.proximo())     // TERCA

DiaSemana.entries.forEach { println(it) }
DiaSemana.valueOf("SEXTA") // DiaSemana.SEXTA
```

### Enum com when (exaustivo!)
```kotlin
fun descricaoDia(dia: DiaSemana): String = when (dia) {
    DiaSemana.SABADO, DiaSemana.DOMINGO -> "Final de semana"
    DiaSemana.SEXTA -> "Sextou!"
    else -> "Dia útil"
}
```

### Enum com método abstrato
```kotlin
enum class Operacao(val simbolo: Char) {
    SOMA('+') {
        override fun calcular(a: Double, b: Double) = a + b
    },
    SUBTRACAO('-') {
        override fun calcular(a: Double, b: Double) = a - b
    },
    MULTIPLICACAO('*') {
        override fun calcular(a: Double, b: Double) = a * b
    };

    abstract fun calcular(a: Double, b: Double): Double
}

println(Operacao.SOMA.calcular(10.0, 5.0))           // 15.0
println(Operacao.MULTIPLICACAO.calcular(3.0, 4.0))   // 12.0
```

---

## 5. Sealed Classes

Hierarquia restrita de classes: todas as subclasses devem ser definidas **no mesmo arquivo** (ou mesmo pacote com Kotlin 1.5+). Permite `when` exaustivo sem `else`.

```kotlin
sealed class Resultado<out T> {
    data class Sucesso<T>(val dados: T) : Resultado<T>()
    data class Erro(val mensagem: String, val causa: Exception? = null) : Resultado<Nothing>()
    object Carregando : Resultado<Nothing>()
}

fun processarResultado(resultado: Resultado<String>) = when (resultado) {
    is Resultado.Sucesso -> println("Dados: ${resultado.dados}")
    is Resultado.Erro -> println("Erro: ${resultado.mensagem}")
    Resultado.Carregando -> println("Carregando...")
    // sem 'else' — compilador sabe que todos os casos foram cobertos!
}

processarResultado(Resultado.Sucesso("Dados recebidos"))
processarResultado(Resultado.Erro("Timeout"))
processarResultado(Resultado.Carregando)
```

### Sealed Interface
```kotlin
sealed interface EstadoPedido

data class Pendente(val id: String) : EstadoPedido
data class Processando(val id: String, val progresso: Int) : EstadoPedido
data class Entregue(val id: String, val dataEntrega: String) : EstadoPedido
data class Cancelado(val id: String, val motivo: String) : EstadoPedido

fun descricaoEstado(estado: EstadoPedido) = when (estado) {
    is Pendente -> "Pedido ${estado.id} aguardando processamento"
    is Processando -> "Pedido ${estado.id} - ${estado.progresso}% concluído"
    is Entregue -> "Pedido ${estado.id} entregue em ${estado.dataEntrega}"
    is Cancelado -> "Pedido ${estado.id} cancelado: ${estado.motivo}"
}
```

### Sealed vs Enum vs Abstract

| Aspecto               | Sealed             | Enum               | Abstract           |
|-----------------------|--------------------|--------------------|--------------------|
| Número de instâncias  | Múltiplas por tipo | Uma por constante  | Ilimitado          |
| Subtipos diferentes   | Sim                | Não                | Sim                |
| when exaustivo        | Sim                | Sim                | Não                |
| Estado variável       | Sim                | Sim (por constante)| Sim                |
| Uso típico            | Estados, erros     | Opções fixas       | Base de hierarquia |
