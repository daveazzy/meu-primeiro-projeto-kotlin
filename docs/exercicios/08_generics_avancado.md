# Exercícios — Generics e Conceitos Avançados

---

## Funções Genéricas

**Ex 1.** Crie as seguintes funções genéricas:
- `fun <T> primeiroOuPadrao(lista: List<T>, padrao: T): T`
- `fun <T> ultimoOuNull(lista: List<T>): T?`
- `fun <T> inverterLista(lista: List<T>): List<T>` sem usar `.reversed()`

**Ex 2.** Crie uma função `fun <T, R> transformarSeFornecido(valor: T?, transformacao: (T) -> R): R?` que aplica a transformação apenas se o valor não for null.

**Ex 3.** Crie uma função `fun <T : Comparable<T>> clamp(valor: T, minimo: T, maximo: T): T` que limita o valor ao intervalo [minimo, maximo].
```kotlin
clamp(5, 1, 10)    // 5
clamp(-3, 1, 10)   // 1
clamp(15, 1, 10)   // 10
clamp("z", "a", "m")  // "m"
```

**Ex 4.** Crie `fun <A, B, C> compor(f: (A) -> B, g: (B) -> C): (A) -> C` que compõe duas funções.
```kotlin
val dobrar = { x: Int -> x * 2 }
val somar10 = { x: Int -> x + 10 }
val dobrarESomar10 = compor(dobrar, somar10)
dobrarESomar10(5)   // 20
```

---

## Classes Genéricas

**Ex 5.** Crie uma classe `Resultado<T, E>` com dois subtipos:
```kotlin
sealed class Resultado<out T, out E> {
    data class Ok<T>(val valor: T) : Resultado<T, Nothing>()
    data class Falha<E>(val erro: E) : Resultado<Nothing, E>()
}
```
Adicione métodos:
- `fun <R> mapear(f: (T) -> R): Resultado<R, E>`
- `fun ouPadrao(padrao: T): T`
- `fun ehOk(): Boolean`

**Ex 6.** Implemente uma classe `Fila<T>` (queue) genérica com:
- `enfileirar(item: T)`
- `desenfileirar(): T?`
- `frente(): T?`
- `estaVazia(): Boolean`
- `tamanho: Int`

**Ex 7.** Crie um `class GrafoSimples<T>` que representa um grafo não-direcionado:
- `adicionarVertice(vertice: T)`
- `adicionarAresta(de: T, para: T)`
- `vizinhos(vertice: T): Set<T>`
- `estaConectado(de: T, para: T): Boolean`

---

## Restrições de Tipo

**Ex 8.** Crie uma função `fun <T : Number> somar(lista: List<T>): Double` que soma qualquer lista de números (Int, Double, Float, etc.).

**Ex 9.** Crie uma função `fun <T : Comparable<T>> ordenar(lista: List<T>): List<T>` implementando bubblesort sem usar as funções de ordenação do stdlib.

**Ex 10.** Crie uma classe `MinHeap<T : Comparable<T>>` simples com `inserir(item: T)` e `extrairMinimo(): T?`.

---

## Extensões Genéricas

**Ex 11.** Crie as seguintes extensões genéricas:
```kotlin
fun <T> List<T>.segundo(): T?
fun <T> List<T>.penultimo(): T?
fun <T> List<T>.embaralhar(): List<T>      // sem usar shuffle
fun <T> List<T>.dividirEm(n: Int): List<List<T>>   // divide em sublistas de n elementos
```

**Ex 12.** Crie uma extensão `fun <T, K> List<T>.agruparContando(seletor: (T) -> K): Map<K, Int>` que conta ocorrências por grupo:
```kotlin
listOf("ana", "bob", "alice", "bruno").agruparContando { it.first() }
// {'a' to 2, 'b' to 2}
```

---

## Variância (in/out)

**Ex 13.** Explique com código por que este código não compila:
```kotlin
fun processar(lista: MutableList<Any>) { lista.add("texto") }
val numeros: MutableList<Int> = mutableListOf(1, 2, 3)
processar(numeros)  // por que é um problema?
```

**Ex 14.** Crie uma interface `Produtor<out T>` e uma `Consumidor<in T>`. Demonstre que:
- `Produtor<String>` pode ser atribuído a `Produtor<Any>`
- `Consumidor<Any>` pode ser atribuído a `Consumidor<String>`

**Ex 15.** Crie uma função que imprime elementos de qualquer lista usando star projection:
```kotlin
fun imprimirQualquerLista(lista: List<*>)
```
Por que `List<*>` é diferente de `List<Any>`?

**Ex 16.** Implemente um `class CopiadorDados<in T, out R>(val transformar: (T) -> R)` que:
- Aceita qualquer subtipo de T como entrada (in)
- Produz qualquer supertipo de R como saída (out)
Demonstre com um exemplo concreto.

---

## Inline e Reified

**Ex 17.** Crie `inline fun <reified T> List<Any>.filterByType(): List<T>` e teste com uma lista misturando Int, String, Double e Boolean.

**Ex 18.** Crie `inline fun <reified T : Any> criarInstanciaComReflexao(): T` que usa `T::class.java.getDeclaredConstructor().newInstance()`. Teste com uma data class simples.

**Ex 19.** Implemente `inline fun <reified T> String.tentarConverter(): T?` que tenta converter uma string para o tipo T:
- String → retorna a própria string
- Int → usa `toIntOrNull()`
- Double → usa `toDoubleOrNull()`
- Boolean → usa `toBooleanStrictOrNull()`
- outros → retorna null

**Ex 20.** Crie uma função `inline fun medir(nome: String = "bloco", bloco: () -> Unit)` que usa `System.nanoTime()` para medir a performance e imprima em microssegundos. Compare a performance de:
- Somar 1 milhão de números com `for`
- Somar 1 milhão de números com `fold`

---

## Desafios

**Desafio A.** Implemente um `class Cache<K, V>(val maxSize: Int)` com política LRU (Least Recently Used):
- `fun get(chave: K): V?`
- `fun put(chave: K, valor: V)`
- Quando cheio, remove o item acessado menos recentemente
- Use `LinkedHashMap` internamente

**Desafio B.** Crie um framework de validação genérico:
```kotlin
class Validador<T> {
    fun regra(descricao: String, predicado: (T) -> Boolean): Validador<T>
    fun validar(valor: T): List<String>  // lista de erros
}
```
Use para validar um formulário com campos de diferentes tipos.

**Desafio C.** Implemente `class Observavel<T>` (padrão Observer genérico):
- `fun assinar(observador: (T) -> Unit): () -> Unit` — retorna função para cancelar
- `fun emitir(valor: T)` — notifica todos os observadores
- `fun <R> mapear(transformacao: (T) -> R): Observavel<R>` — cria novo observável transformado
- `fun filtrar(predicado: (T) -> Boolean): Observavel<T>` — filtra emissões
