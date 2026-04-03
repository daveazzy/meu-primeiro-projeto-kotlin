# Funções em Kotlin

Kotlin tem suporte robusto para programação funcional. Funções são cidadãos de primeira classe — podem ser armazenadas em variáveis, passadas como argumentos e retornadas de outras funções.

---

## 1. Funções Nomeadas

### Sintaxe básica
```kotlin
fun somar(a: Int, b: Int): Int {
    return a + b
}
```

### Expressão de corpo (single-expression)
Quando o corpo tem apenas uma expressão, pode ser simplificado:
```kotlin
fun somar(a: Int, b: Int): Int = a + b
fun somar(a: Int, b: Int) = a + b  // tipo de retorno inferido
```

### Sem retorno (Unit)
`Unit` é equivalente ao `void` de Java. Pode ser omitido:
```kotlin
fun imprimirSaudacao(nome: String): Unit {
    println("Olá, $nome!")
}
// Equivalente:
fun imprimirSaudacao(nome: String) {
    println("Olá, $nome!")
}
```

### Parâmetros padrão
```kotlin
fun conectar(host: String, porta: Int = 8080, seguro: Boolean = false) {
    println("Conectando em $host:$porta (seguro=$seguro)")
}

conectar("localhost")                     // usa padrões
conectar("servidor.com", 443, true)       // todos explícitos
```

### Parâmetros nomeados
Aumentam a legibilidade e permitem alterar a ordem:
```kotlin
conectar(host = "servidor.com", seguro = true, porta = 443)
conectar(porta = 3306, host = "banco.com")
```

### Número variável de argumentos (vararg)
```kotlin
fun somar(vararg numeros: Int): Int = numeros.sum()

somar(1, 2, 3)       // 6
somar(1, 2, 3, 4, 5) // 15

// Desempacotar array com *
val nums = intArrayOf(1, 2, 3)
somar(*nums)
```

---

## 2. Funções Anônimas e Lambdas

### Lambda básico
```kotlin
val somar: (Int, Int) -> Int = { a, b -> a + b }
val dobro: (Int) -> Int = { it * 2 }   // it: parâmetro implícito quando há só um
val saudar: (String) -> Unit = { nome -> println("Olá, $nome!") }
```

### Tipos de função
```kotlin
// (TipoParam1, TipoParam2, ...) -> TipoRetorno
val soma: (Int, Int) -> Int
val semRetorno: (String) -> Unit
val semParametros: () -> String
```

### Invocação
```kotlin
val multiplicar = { a: Int, b: Int -> a * b }
multiplicar(3, 4)           // 12
multiplicar.invoke(3, 4)    // equivalente
```

### Lambdas com múltiplas linhas
```kotlin
val processar = { numero: Int ->
    val dobrado = numero * 2
    val mais10 = dobrado + 10
    mais10   // última expressão é o retorno
}
```

### Captura de variáveis (closure)
Lambdas podem capturar variáveis do escopo externo:
```kotlin
var total = 0
val acumular = { valor: Int -> total += valor }
acumular(10)
acumular(20)
println(total)   // 30
```

---

## 3. Funções de Ordem Superior (Higher-Order Functions)

Funções que aceitam outras funções como parâmetros ou as retornam.

### Aceitando função como parâmetro
```kotlin
fun operacaoMatematica(a: Int, b: Int, operacao: (Int, Int) -> Int): Int {
    return operacao(a, b)
}

operacaoMatematica(10, 5, { a, b -> a + b })   // 15
operacaoMatematica(10, 5, { a, b -> a * b })   // 50
```

### Trailing lambda (lambda após os parênteses)
Se o último parâmetro é uma função, o lambda pode sair dos parênteses:
```kotlin
// Equivalentes:
operacaoMatematica(10, 5, { a, b -> a + b })
operacaoMatematica(10, 5) { a, b -> a + b }

// Se o lambda é o único parâmetro:
numeros.forEach({ println(it) })
numeros.forEach { println(it) }  // trailing lambda
```

### Referência de função `::nomeDaFuncao`
```kotlin
fun ehPar(n: Int) = n % 2 == 0

val numeros = listOf(1, 2, 3, 4, 5)
numeros.filter(::ehPar)         // [2, 4]
numeros.forEach(::println)
```

### Retornando funções
```kotlin
fun criarMultiplicador(fator: Int): (Int) -> Int {
    return { numero -> numero * fator }
}

val triplicar = criarMultiplicador(3)
triplicar(5)    // 15
triplicar(10)   // 30
```

### Funções úteis da biblioteca padrão que aceitam lambdas
```kotlin
listOf(1, 2, 3).map { it * 2 }
listOf(1, 2, 3).filter { it > 1 }
listOf(1, 2, 3).reduce { acc, i -> acc + i }
listOf(1, 2, 3).fold(10) { acc, i -> acc + i }  // 16 (começa em 10)
listOf(1, 2, 3).sortedBy { it }
listOf("a", "bb", "ccc").maxByOrNull { it.length }
```

---

## 4. Funções de Extensão

Permitem adicionar novos métodos a tipos existentes sem herança ou decoradores:

```kotlin
fun String.isPalindrome(): Boolean {
    val limpo = this.lowercase().replace(" ", "")
    return limpo == limpo.reversed()
}

"radar".isPalindrome()        // true
"Ame a ema".isPalindrome()    // true
"hello".isPalindrome()        // false
```

### Extensão em tipos primitivos
```kotlin
fun Double.arredondar(casas: Int): String {
    return "%.${casas}f".format(this)
}

3.14159.arredondar(2)    // "3.14"
```

### Extensão com receiver
```kotlin
fun Int.ehPar() = this % 2 == 0
fun Int.ehImpar() = !this.ehPar()
fun Int.fatorial(): Long = if (this <= 1) 1L else this * (this - 1).fatorial()

4.ehPar()       // true
5.ehImpar()     // true
5.fatorial()    // 120
```

### Extensão em nullable
```kotlin
fun String?.isNullOrBlankCustom(): Boolean {
    return this == null || this.isBlank()
}

null.isNullOrBlankCustom()     // true
"".isNullOrBlankCustom()       // true
"texto".isNullOrBlankCustom()  // false
```

---

## 5. Funções Infix

Funções com notação especial: sem parênteses e sem ponto.

**Requisitos:**
- Deve ser método de membro ou extensão
- Deve ter exatamente **um** parâmetro (sem vararg, sem padrão)
- Deve ser marcada com `infix`

```kotlin
infix fun Int.somaCom(outro: Int): Int = this + outro
infix fun String.repete(vezes: Int): String = repeat(vezes)

val resultado = 5 somaCom 3        // 8
val texto = "Oi " repete 3         // "Oi Oi Oi "
```

### Exemplos do stdlib
```kotlin
1 to "um"           // Pair<Int, String> — equivalente a Pair(1, "um")
a until b           // IntRange — equivalente a a.until(b)
1 shr 2             // shift right: operação de bits
```

### Encadeamento de infix
```kotlin
infix fun Boolean.e(outro: Boolean) = this && outro
infix fun Boolean.ou(outro: Boolean) = this || outro

val resultado = (5 > 3) e (10 > 5) ou false   // true
```

---

## 6. Funções Inline

Marcadas com `inline`, têm o corpo copiado para o local da chamada em tempo de compilação — eliminando o overhead de criação de objeto lambda:

```kotlin
inline fun medirTempo(acao: () -> Unit): Long {
    val inicio = System.currentTimeMillis()
    acao()
    return System.currentTimeMillis() - inicio
}

val tempo = medirTempo {
    Thread.sleep(100)
}
println("Levou ${tempo}ms")
```

**Quando usar `inline`:**
- Funções que recebem lambdas e são chamadas frequentemente
- O código do lambda é pequeno
- Evita a alocação de objeto lambda em loops críticos

---

## 7. Reified — Tipo genérico em tempo de execução

Normalmente, o tipo genérico é apagado em tempo de execução (type erasure). Com `reified` em uma função `inline`, o tipo fica disponível:

```kotlin
inline fun <reified T> verificarTipo(valor: Any): Boolean {
    return valor is T
}

verificarTipo<String>("texto")   // true
verificarTipo<Int>("texto")      // false
```

```kotlin
inline fun <reified T> criarInstancia(): T {
    return T::class.java.getDeclaredConstructor().newInstance()
}
```

---

## 8. Resumo dos tipos de função

| Tipo                 | Quando usar                                          |
|----------------------|------------------------------------------------------|
| Nomeada              | Lógica reutilizável com nome descritivo              |
| Lambda / Anônima     | Passagem como argumento, código conciso              |
| Extensão             | Adicionar comportamento a tipos existentes           |
| Infix                | DSLs, leitura mais natural para operações binárias   |
| Ordem superior       | Algoritmos parametrizáveis por comportamento         |
| Inline               | Funções com lambdas em contexto de performance       |
| Inline + reified     | Funções genéricas que precisam do tipo em runtime    |
