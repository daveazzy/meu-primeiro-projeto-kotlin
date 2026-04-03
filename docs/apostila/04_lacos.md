# Laços de Repetição

## 1. for

### Iterando sobre coleções
```kotlin
val frutas = listOf("maçã", "banana", "laranja")
for (fruta in frutas) {
    println(fruta)
}
```

### Iterando com índice
```kotlin
for ((indice, fruta) in frutas.withIndex()) {
    println("$indice: $fruta")
}
```

### Iterando sobre ranges (intervalos)
```kotlin
for (i in 1..5) println(i)       // 1 2 3 4 5  (inclui o 5)
for (i in 1 until 5) println(i)  // 1 2 3 4     (exclui o 5)
for (i in 5 downTo 1) println(i) // 5 4 3 2 1  (decrescente)
for (i in 0..10 step 2) println(i)  // 0 2 4 6 8 10  (passo 2)
```

### Iterando sobre String
```kotlin
for (char in "Kotlin") {
    print("$char ")   // K o t l i n
}
```

### Iterando sobre Map
```kotlin
val mapa = mapOf("a" to 1, "b" to 2)
for ((chave, valor) in mapa) {
    println("$chave -> $valor")
}
```

---

## 2. forEach

Mais idiomático em Kotlin para iterar coleções:

```kotlin
val numeros = listOf(1, 2, 3, 4, 5)

// Lambda completo
numeros.forEach { numero ->
    println(numero)
}

// Com it implícito
numeros.forEach { println(it) }

// Referência de método
numeros.forEach(::println)
```

### forEachIndexed
```kotlin
numeros.forEachIndexed { indice, valor ->
    println("[$indice] = $valor")
}
```

---

## 3. while

Executa enquanto a condição for verdadeira. A condição é verificada **antes** de cada execução:

```kotlin
var contador = 0
while (contador < 5) {
    println(contador)
    contador++
}
```

Cuidado com loops infinitos:
```kotlin
// Loop infinito com saída controlada
var tentativas = 0
while (true) {
    tentativas++
    if (tentativas >= 3) break
}
```

---

## 4. do-while

Semelhante ao while, mas a condição é verificada **depois** da primeira execução. O bloco **sempre executa pelo menos uma vez**:

```kotlin
var numero: Int
do {
    print("Digite um número positivo: ")
    numero = readln().toInt()
} while (numero <= 0)

println("Você digitou: $numero")
```

---

## 5. break e continue

### break — interrompe o loop
```kotlin
for (i in 1..10) {
    if (i == 5) break
    println(i)   // imprime 1 2 3 4
}
```

### continue — pula para a próxima iteração
```kotlin
for (i in 1..10) {
    if (i % 2 == 0) continue
    println(i)   // imprime 1 3 5 7 9
}
```

---

## 6. Loops aninhados e Labels

O problema dos loops aninhados: `break` só sai do loop mais interno.

```kotlin
// Sem label — break só sai do loop interno
for (i in 1..3) {
    for (j in 1..3) {
        if (j == 2) break     // só sai do for(j)
        println("$i, $j")
    }
}
```

### Labels — saindo do loop externo
```kotlin
externo@ for (i in 1..3) {
    for (j in 1..3) {
        if (i == 2 && j == 2) break@externo   // sai do for(i)
        println("$i, $j")
    }
}
```

### continue com label
```kotlin
externo@ for (i in 1..3) {
    for (j in 1..3) {
        if (j == 2) continue@externo   // pula para próxima iteração do for(i)
        println("$i, $j")
    }
}
```

---

## 7. repeat

Quando você precisa executar um bloco N vezes sem usar um índice:

```kotlin
repeat(5) {
    println("Executando...")
}

// Com índice (começa em 0)
repeat(5) { indice ->
    println("Iteração $indice")
}
```

---

## 8. Comparação: for vs forEach vs repeat

| Situação                              | Use          |
|---------------------------------------|--------------|
| Iterar coleção com índice             | `for` com `withIndex()` |
| Iterar coleção, estilo funcional      | `forEach`    |
| Range ou progressão                   | `for` com `..` / `until` / `downTo` / `step` |
| Repetir N vezes                       | `repeat(n)`  |
| Condição como critério de parada      | `while`      |
| Deve executar ao menos uma vez        | `do-while`   |

---

## 9. Operações funcionais equivalentes a loops

Muitas vezes, uma operação de coleção é mais expressiva que um loop:

```kotlin
val numeros = listOf(1, 2, 3, 4, 5, 6)

// Em vez de loop com if:
numeros.filter { it % 2 == 0 }          // [2, 4, 6]

// Em vez de loop acumulando:
numeros.map { it * it }                  // [1, 4, 9, 16, 25, 36]

// Em vez de loop somando:
numeros.sum()                            // 21
numeros.reduce { acc, i -> acc + i }     // 21

// Em vez de loop verificando:
numeros.any { it > 5 }                   // true
numeros.all { it > 0 }                   // true
```
