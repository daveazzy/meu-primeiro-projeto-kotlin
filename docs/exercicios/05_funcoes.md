# Exercícios — Funções

---

## Funções Nomeadas

**Ex 1.** Crie uma função `ehPalindromo(texto: String): Boolean` que retorna true se a string for igual ao reverso dela mesma (ignore maiúsculas/minúsculas).

**Ex 2.** Crie uma função `calcularMedia(vararg notas: Double): Double` que aceita qualquer quantidade de notas e retorna a média. Teste com 3, 5 e 7 notas.

**Ex 3.** Crie uma função `saudar(nome: String, saudacao: String = "Olá", pontuacao: String = "!")` com parâmetros padrão. Chame-a de 4 formas diferentes usando parâmetros nomeados.

**Ex 4.** Escreva a função `fatorial(n: Int): Long` de forma recursiva e depois como single-expression function.

---

## Lambdas e Funções Anônimas

**Ex 5.** Crie os seguintes lambdas:
- `val dobrar: (Int) -> Int` que retorna o dobro
- `val ehMaior18: (Int) -> Boolean` que verifica se é maior que 18
- `val concatenar: (String, String) -> String` que une duas strings com espaço

**Ex 6.** Crie um lambda que captura uma variável externa (closure) para contar quantas vezes foi chamado:
```kotlin
var chamadas = 0
val contador = { /* implemente */ }
```
Chame o lambda 5 vezes e verifique o valor de `chamadas`.

**Ex 7.** Crie uma lista de lambdas `List<(Int) -> Int>` com operações: dobrar, triplicar, somar 10, elevar ao quadrado. Aplique cada operação ao número 5 e imprima os resultados.

---

## Funções de Ordem Superior

**Ex 8.** Crie uma função `aplicarDuasVezes(valor: Int, operacao: (Int) -> Int): Int` que aplica a operação duas vezes. Teste com as operações: dobrar, somar 3.

**Ex 9.** Implemente sua própria versão do `filter`:
```kotlin
fun <T> meuFilter(lista: List<T>, predicado: (T) -> Boolean): List<T>
```
Teste filtrando números pares e strings com mais de 3 letras.

**Ex 10.** Implemente sua própria versão do `map`:
```kotlin
fun <T, R> meuMap(lista: List<T>, transformacao: (T) -> R): List<R>
```

**Ex 11.** Crie uma função `executarComRetry(vezes: Int, acao: () -> Boolean): Boolean` que executa a ação até `vezes` vezes, parando se retornar true. Simule uma ação que falha nas duas primeiras tentativas e sucede na terceira.

**Ex 12.** Use referência de função (`::`) para passar as seguintes funções como argumento para `map` e `filter`:
```kotlin
fun duplicar(n: Int) = n * 2
fun ehPositivo(n: Int) = n > 0
```

---

## Funções de Extensão

**Ex 13.** Crie as seguintes extensões:
- `fun String.capitalizar(): String` — primeira letra maiúscula, resto minúsculo
- `fun String.contarPalavras(): Int` — conta palavras separadas por espaço
- `fun String.inverter(): String` — retorna a string invertida

**Ex 14.** Crie extensões para `Int`:
- `fun Int.ehPar(): Boolean`
- `fun Int.ehImpar(): Boolean`
- `fun Int.entre(min: Int, max: Int): Boolean`
- `fun Int.fatorial(): Long`

**Ex 15.** Crie uma extensão `fun List<Int>.estatisticas()` que imprima: tamanho, soma, média, mínimo e máximo da lista.

**Ex 16.** Crie uma extensão `fun Double.paraReal(): String` que formata um número como valor em Reais: `1500.5.paraReal()` → `"R$ 1.500,50"`.

---

## Funções Infix

**Ex 17.** Crie as seguintes funções infix:
- `infix fun Int.elevadoA(exp: Int): Double`
- `infix fun String.repetir(vezes: Int): String`
- `infix fun <T> T.estaEm(lista: List<T>): Boolean`

**Ex 18.** Crie uma DSL simples para comparação usando infix:
```kotlin
// Objetivo: escrever código como:
val resultado = 5 eMaiorQue 3   // true
val resultado2 = "kotlin" temTamanho 6   // true
```

---

## Inline e Reified

**Ex 19.** Crie uma função `inline fun cronometrar(nome: String, bloco: () -> Unit)` que imprime o tempo de execução em milissegundos. Teste com um loop de 10 milhões de iterações.

**Ex 20.** Implemente uma função `inline fun <reified T> List<Any>.contarDoTipo(): Int` que conta quantos elementos da lista são do tipo T.

**Ex 21.** Crie `inline fun <reified T> Any.eDoTipo(): Boolean` que verifica se o objeto é do tipo T.

---

## Desafios

**Desafio A.** Implemente um pipeline de transformação funcional:
```kotlin
val pipeline = listOf<(Int) -> Int>(
    { it * 2 },
    { it + 10 },
    { it * it }
)
```
Crie uma função `fun <T> aplicarPipeline(valor: T, passos: List<(T) -> T>): T` que aplica cada transformação em sequência.

**Desafio B.** Memoização: crie uma função `fun <T, R> memoizar(funcao: (T) -> R): (T) -> R` que armazena resultados já calculados em um cache. Teste com uma função custosa de fibonacci.

**Desafio C.** Crie extensões para `List<String>` que formam uma mini DSL:
```kotlin
val resultado = palavras
    .semRepetidas()
    .comTamanhoMinimo(3)
    .normalizadas()       // lowercase e sem espaços extras
    .ordenadas()
```
