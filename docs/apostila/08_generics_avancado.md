# Generics e Conceitos Avançados

## 1. Generics — Programação com Tipos Genéricos

Generics permitem escrever código que funciona com qualquer tipo, mantendo segurança de tipos em tempo de compilação.

### Sem generics (problemático)
```kotlin
// Funciona com Any, mas perde segurança de tipo
fun imprimirItem(item: Any) = println(item)
val lista: List<Any> = listOf(1, "texto", true)  // mistura tipos
```

### Com generics (seguro)
```kotlin
fun <T> imprimirItem(item: T) = println(item)

// A chamada é tipada:
imprimirItem<String>("texto")  // OK
imprimirItem(42)               // tipo inferido: Int
```

---

## 2. Funções Genéricas

```kotlin
fun <T> primeiroOuNulo(lista: List<T>): T? {
    return if (lista.isEmpty()) null else lista[0]
}

primeiroOuNulo(listOf(1, 2, 3))      // 1
primeiroOuNulo(listOf("a", "b"))     // "a"
primeiroOuNulo(emptyList<Int>())     // null
```

### Múltiplos parâmetros de tipo
```kotlin
fun <K, V> exibirPar(chave: K, valor: V) {
    println("$chave -> $valor")
}

exibirPar("nome", "Davidson")
exibirPar(1, true)
```

### Restrições de tipo (upper bound)
```kotlin
// T deve ser Comparable (pode ser comparado)
fun <T : Comparable<T>> maior(a: T, b: T): T {
    return if (a > b) a else b
}

maior(10, 20)          // 20
maior("abc", "xyz")    // "xyz"
// maior(listOf(1), listOf(2))  // ERRO: List não é Comparable
```

### Múltiplas restrições com where
```kotlin
fun <T> processar(item: T) where T : Comparable<T>, T : Cloneable {
    // T deve ser Comparable E Cloneable
}
```

---

## 3. Classes Genéricas

```kotlin
class Caixa<T>(val conteudo: T) {
    fun abrir(): T = conteudo
    fun descrever() = "Caixa contendo: ${conteudo}"
}

val caixaInt = Caixa(42)
val caixaStr = Caixa("presente")
println(caixaInt.abrir())     // 42
println(caixaStr.descrever()) // Caixa contendo: presente
```

### Classe genérica com múltiplos tipos
```kotlin
class Par<A, B>(val primeiro: A, val segundo: B) {
    fun trocar(): Par<B, A> = Par(segundo, primeiro)
    override fun toString() = "($primeiro, $segundo)"
}

val par = Par("Davidson", 25)
val trocado = par.trocar()   // (25, Davidson)
```

---

## 4. Interfaces Genéricas

```kotlin
interface Repositorio<T, ID> {
    fun buscarPorId(id: ID): T?
    fun salvar(item: T): T
    fun deletar(id: ID)
    fun listarTodos(): List<T>
}

data class Usuario(val id: Int, val nome: String)

class RepositorioUsuario : Repositorio<Usuario, Int> {
    private val banco = mutableMapOf<Int, Usuario>()

    override fun buscarPorId(id: Int) = banco[id]
    override fun salvar(item: Usuario) = item.also { banco[it.id] = it }
    override fun deletar(id: Int) { banco.remove(id) }
    override fun listarTodos() = banco.values.toList()
}
```

---

## 5. Extensões Genéricas

```kotlin
// Extensão genérica na List
fun <T> List<T>.segundo(): T? = if (size >= 2) this[1] else null

fun <T> List<T>.exibirTodos() {
    forEachIndexed { i, item -> println("[$i] $item") }
}

listOf(1, 2, 3).segundo()    // 2
listOf("a").segundo()        // null
```

---

## 6. Variância — in e out

**O problema:** suponha `Animal` e `Cachorro : Animal`. Por que `List<Cachorro>` não pode ser usado onde se espera `List<Animal>`?

Porque se fosse possível, poderíamos adicionar um `Gato` em uma lista de `Cachorro` — quebrando a segurança de tipo.

Kotlin resolve com anotações de variância em tempo de compilação.

### out — Covariância (produtor)

`out T` significa que o tipo só **produz** T (só retorna, nunca recebe como input):

```kotlin
class Caixa<out T>(val conteudo: T) {
    fun abrir(): T = conteudo
    // fun colocar(item: T) { }  // ERRO! out não pode ser input
}

// Agora funciona:
val caixaCachorro: Caixa<Cachorro> = Caixa(Cachorro())
val caixaAnimal: Caixa<Animal> = caixaCachorro   // OK com 'out'
```

Analogia: uma caixa que só deixa tirar, nunca colocar — é seguro tratá-la como uma caixa de Animal.

### in — Contravariância (consumidor)

`in T` significa que o tipo só **consome** T (só recebe, nunca retorna):

```kotlin
class Alimentador<in T> {
    fun alimentar(animal: T) {
        println("Alimentando $animal")
    }
    // fun obterAnimal(): T { }  // ERRO! in não pode retornar
}

val alimentadorAnimal: Alimentador<Animal> = Alimentador()
val alimentadorCachorro: Alimentador<Cachorro> = alimentadorAnimal   // OK com 'in'
```

Analogia: um alimentador de Animal pode alimentar qualquer animal, incluindo cachorros.

### Resumo de variância

| Modificador | Nome             | Permite subtyping            | Uso         |
|-------------|------------------|------------------------------|-------------|
| (nenhum)    | Invariante       | Não                          | Leitura e escrita |
| `out`       | Covariante       | `Box<Dog>` → `Box<Animal>`   | Apenas produz |
| `in`        | Contravariante   | `Box<Animal>` → `Box<Dog>`   | Apenas consome |

### Star projection `*`
Quando você não sabe o tipo, mas precisa lidar com a coleção:
```kotlin
fun imprimirLista(lista: List<*>) {
    lista.forEach { println(it) }  // it é Any?
}
```

---

## 7. Inline Functions

Funções `inline` têm seu corpo **copiado** para cada ponto de chamada pelo compilador:

```kotlin
inline fun executarComLog(nome: String, acao: () -> Unit) {
    println("Iniciando: $nome")
    acao()
    println("Concluído: $nome")
}

executarComLog("tarefa1") {
    println("Fazendo trabalho...")
}
// O compilador gera código equivalente a:
// println("Iniciando: tarefa1")
// println("Fazendo trabalho...")
// println("Concluído: tarefa1")
```

**Por que usar inline?**
- Evita criação de objeto lambda (melhor performance em loops)
- Permite `return` não-local (retornar do escopo externo)

### Return não-local
```kotlin
fun buscarPrimeiroPositivo(lista: List<Int>): Int? {
    lista.forEach {
        if (it > 0) return it   // só funciona porque forEach é inline!
        // sem inline, isso seria erro (return de lambda)
    }
    return null
}
```

### noinline e crossinline
```kotlin
inline fun exemplo(
    noinline naoInline: () -> Unit,   // esse lambda não é inlineado
    crossinline semRetornoLocal: () -> Unit  // não permite return não-local
) { }
```

---

## 8. Reified — Tipo real em runtime

Normalmente, generics sofrem **type erasure**: o tipo é apagado em tempo de execução.

```kotlin
fun <T> ehTipo(valor: Any): Boolean {
    return valor is T   // ERRO: Cannot check for instance of erased type T
}
```

Com `reified` (apenas em funções `inline`):
```kotlin
inline fun <reified T> ehTipo(valor: Any): Boolean {
    return valor is T   // OK!
}

ehTipo<String>("texto")   // true
ehTipo<Int>("texto")      // false
```

### Casos de uso práticos
```kotlin
// Filtrar lista por tipo
inline fun <reified T> List<Any>.filtrarPorTipo(): List<T> {
    return filterIsInstance<T>()
}

val misto = listOf(1, "dois", 3, "quatro", 5)
misto.filtrarPorTipo<String>()   // ["dois", "quatro"]
misto.filtrarPorTipo<Int>()      // [1, 3, 5]
```

```kotlin
// Obter nome do tipo
inline fun <reified T> nomeDoTipo(): String = T::class.simpleName ?: "Desconhecido"

nomeDoTipo<String>()    // "String"
nomeDoTipo<Int>()       // "Int"
nomeDoTipo<List<*>>()   // "List"
```

```kotlin
// Deserializar JSON para tipo específico (padrão em bibliotecas)
inline fun <reified T> String.deserializar(): T {
    return gson.fromJson(this, T::class.java)
}

val usuario = jsonString.deserializar<Usuario>()
```

---

## 9. Resumo dos conceitos avançados

| Conceito    | Para que serve                                               |
|-------------|--------------------------------------------------------------|
| `<T>`       | Funções/classes que funcionam com qualquer tipo              |
| `<T : Tipo>`| Limita T a subtipos de Tipo                                  |
| `out T`     | T é apenas produzido (covariância)                           |
| `in T`      | T é apenas consumido (contravariância)                       |
| `inline`    | Copia o corpo da função — evita overhead de lambda           |
| `reified T` | Permite usar T em is/as/::class dentro de funções inline     |
