# Coleções em Kotlin

Kotlin oferece coleções imutáveis e mutáveis. A convenção é preferir imutáveis e usar mutáveis apenas quando necessário.

---

## 1. Arrays

Arrays têm tamanho fixo e são de baixo nível (similar ao Java):

```kotlin
val numeros = arrayOf(1, 2, 3, 4, 5)
val textos = arrayOf("a", "b", "c")
val tipado: Array<String> = arrayOf("x", "y")
```

### Arrays de primitivos (otimizados)
```kotlin
val inteiros = intArrayOf(1, 2, 3)
val doubles = doubleArrayOf(1.0, 2.0)
val booleans = booleanArrayOf(true, false)
```

### Acesso e modificação
```kotlin
val arr = arrayOf(10, 20, 30)
println(arr[0])       // 10
arr[0] = 99           // modifica
println(arr.size)     // 3
```

### Converter para String legível
```kotlin
val arr = arrayOf(1, 2, 3)
println(arr.joinToString())                                   // 1, 2, 3
println(arr.joinToString(separator = " | "))                  // 1 | 2 | 3
println(arr.joinToString(prefix = "[", postfix = "]"))        // [1, 2, 3]
```

### Concatenar arrays
```kotlin
val a = arrayOf(1, 2)
val b = arrayOf(3, 4)
val c = a + b          // [1, 2, 3, 4]
```

---

## 2. Lists

### Imutável: listOf()
Não permite adição, remoção ou modificação de elementos:
```kotlin
val frutas = listOf("maçã", "banana", "laranja")
println(frutas[0])       // maçã
println(frutas.size)     // 3
```

### Mutável: mutableListOf()
```kotlin
val numeros = mutableListOf(1, 2, 3)
numeros.add(4)
numeros.add(0, 0)    // adiciona no índice 0
numeros.remove(2)    // remove o elemento 2
numeros.removeAt(0)  // remove no índice 0
```

### Acesso
```kotlin
val lista = listOf(10, 20, 30, 40, 50)
lista.first()                    // 10
lista.last()                     // 50
lista[2]                         // 30
lista.elementAt(2)               // 30
lista.getOrNull(10)              // null (sem exceção)
lista.subList(1, 3)              // [20, 30]
lista.indexOf(30)                // 2
lista.indices                    // 0..4
```

### Ordenação
```kotlin
val lista = mutableListOf(3, 1, 4, 1, 5)
lista.sorted()                   // [1, 1, 3, 4, 5] (nova lista)
lista.sortedDescending()         // [5, 4, 3, 1, 1]
lista.reversed()                 // [5, 1, 4, 1, 3]
lista.sort()                     // ordena in-place (só mutableList)
```

### Busca
```kotlin
val lista = listOf(1, 2, 3, 4, 5)
lista.find { it > 3 }            // 4 (primeiro que satisfaz)
lista.findLast { it > 3 }        // 5 (último que satisfaz)
lista.any { it > 4 }             // true
lista.all { it > 0 }             // true
lista.none { it > 10 }           // true
lista.count { it % 2 == 0 }      // 2
```

### Filtragem
```kotlin
val lista = listOf(1, 2, 3, 4, 5, 6)
lista.filter { it % 2 == 0 }             // [2, 4, 6]
lista.filterNot { it % 2 == 0 }          // [1, 3, 5]
lista.drop(2)                             // [3, 4, 5, 6] (remove os 2 primeiros)
lista.dropLast(2)                         // [1, 2, 3, 4]
lista.dropWhile { it < 3 }               // [3, 4, 5, 6]
lista.take(3)                             // [1, 2, 3]
lista.takeLast(2)                         // [5, 6]

// Filtro por tipo
val misto = listOf(1, "texto", 2.0, true)
misto.filterIsInstance<Int>()             // [1]
misto.filterIsInstance<String>()          // ["texto"]
```

### Transformação
```kotlin
val numeros = listOf(1, 2, 3)
numeros.map { it * 2 }                           // [2, 4, 6]
numeros.mapIndexed { i, v -> "$i:$v" }           // ["0:1", "1:2", "2:3"]
numeros.flatMap { listOf(it, it * 10) }          // [1, 10, 2, 20, 3, 30]

val lista1 = listOf(1, 2, 3)
val lista2 = listOf("a", "b", "c")
lista1.zip(lista2)                               // [(1, a), (2, b), (3, c)]
```

### Verificações
```kotlin
lista.isEmpty()
lista.isNotEmpty()
lista.size
lista.contains(3)    // ou: 3 in lista
lista.max()
lista.min()
lista.sum()
lista.average()
```

---

## 3. Sets (Conjuntos)

Sets **não permitem elementos duplicados** e não garantem ordem de inserção (exceto `linkedSetOf`).

### Imutável
```kotlin
val setA = setOf(1, 2, 3, 3, 2)     // {1, 2, 3} — duplicatas removidas
println(setA.size)                   // 3
```

### Mutável
```kotlin
val set = mutableSetOf("kotlin", "java", "python")
set.add("swift")
set.remove("java")
set.add("kotlin")   // ignorado (já existe)
```

### Operações de conjunto
```kotlin
val a = setOf(1, 2, 3, 4)
val b = setOf(3, 4, 5, 6)

a.union(b)         // {1, 2, 3, 4, 5, 6}   — união
a.intersect(b)     // {3, 4}               — interseção
a.subtract(b)      // {1, 2}               — diferença
```

### hashSetOf vs linkedSetOf vs sortedSetOf
```kotlin
val hash = hashSetOf(3, 1, 2)        // sem ordem garantida
val linked = linkedSetOf(3, 1, 2)    // mantém ordem de inserção
val sorted = sortedSetOf(3, 1, 2)    // sempre ordenado
```

---

## 4. Maps (Dicionários)

Maps armazenam pares **chave → valor**. Chaves são únicas.

### Criação
```kotlin
// Usando Pair
val mapa = mapOf(Pair("nome", "Davidson"), Pair("idade", 25))

// Usando infix "to" (mais idiomático)
val mapa = mapOf("nome" to "Davidson", "idade" to 25)
```

### Acesso
```kotlin
val mapa = mapOf("a" to 1, "b" to 2, "c" to 3)
mapa["a"]                 // 1 (retorna null se não existe)
mapa.getValue("a")        // 1 (lança exceção se não existe)
mapa.getOrDefault("z", 0) // 0
mapa.keys                 // {"a", "b", "c"}
mapa.values               // {1, 2, 3}
mapa.entries              // {a=1, b=2, c=3}
mapa.containsKey("b")     // true
mapa.containsValue(2)     // true
```

### Iteração
```kotlin
for ((chave, valor) in mapa) {
    println("$chave -> $valor")
}

mapa.forEach { (chave, valor) ->
    println("$chave: $valor")
}
```

### Mutável
```kotlin
val mapa = mutableMapOf("nome" to "Davidson")
mapa["sobrenome"] = "Azevedo"   // adiciona
mapa["nome"] = "Dave"           // atualiza
mapa.remove("sobrenome")        // remove
mapa.put("cidade", "Fortaleza") // equivalente ao []
```

### hashMapOf
```kotlin
val mapa = hashMapOf("a" to 1, "b" to 2)  // melhor performance para grandes mapas
```

---

## 5. Resumo: Quando usar cada coleção

| Coleção     | Ordem | Duplicatas | Uso típico                         |
|-------------|-------|------------|------------------------------------|
| List        | Sim   | Sim        | Sequência de elementos             |
| Set         | Não*  | Não        | Conjunto único de valores          |
| Map         | Não*  | Não (chave)| Associação chave → valor           |
| Array       | Sim   | Sim        | Dados de tamanho fixo, baixo nível |

> *LinkedSet e LinkedMap mantêm ordem de inserção. SortedSet/SortedMap mantêm ordem natural.

---

## 6. Conversão entre coleções

```kotlin
val lista = listOf(1, 2, 3, 2, 1)
lista.toSet()        // remove duplicatas
lista.toMutableList()

val set = setOf(1, 2, 3)
set.toList()
set.toMutableSet()

val array = arrayOf(1, 2, 3)
array.toList()
array.toSet()
listOf(1, 2, 3).toTypedArray()
```
