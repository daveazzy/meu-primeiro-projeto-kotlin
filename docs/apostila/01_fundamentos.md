# Fundamentos do Kotlin

## 1. val e var — Mutabilidade e Imutabilidade

Em Kotlin, toda variável é declarada com `val` ou `var`. Essa distinção é fundamental e diferencia Kotlin de linguagens como Java onde tudo é mutável por padrão.

### val — imutável (read-only)
```kotlin
val nome = "Davidson"
// nome = "outro" // ERRO de compilação: val cannot be reassigned
```
Use `val` sempre que possível. É mais seguro, legível e facilita o raciocínio sobre o código.

### var — mutável
```kotlin
var idade = 25
idade = 26 // OK
```

### Tipagem explícita vs implícita
Kotlin infere o tipo automaticamente, mas você pode ser explícito:
```kotlin
val cidade: String = "Fortaleza"   // explícito
val pais = "Brasil"                // inferido como String
var contador: Int = 0
```

### Segurança de tipos
Uma vez declarada, a variável não pode mudar de tipo:
```kotlin
var x = 10
// x = "texto" // ERRO: Type mismatch
```

---

## 2. Tipos de Dados

### Inteiros
| Tipo   | Tamanho | Faixa                                         |
|--------|---------|-----------------------------------------------|
| Byte   | 8 bits  | -128 a 127                                    |
| Short  | 16 bits | -32.768 a 32.767                              |
| Int    | 32 bits | -2.147.483.648 a 2.147.483.647               |
| Long   | 64 bits | -9.223.372.036.854.775.808 a (enorme)        |

```kotlin
val b: Byte = 100
val s: Short = 5000
val i: Int = 2_000_000      // underscore para legibilidade
val l: Long = 32_500L       // sufixo L para Long
```

### Ponto flutuante
| Tipo   | Tamanho | Precisão     |
|--------|---------|--------------|
| Float  | 32 bits | ~6-7 dígitos |
| Double | 64 bits | ~15 dígitos  |

```kotlin
val f: Float = 3.14f        // sufixo f obrigatório
val d: Double = 3.14159265  // padrão sem sufixo
```

### Char
Representa um único caractere Unicode. Usa aspas simples:
```kotlin
val letra: Char = 'A'
val emoji: Char = '\u2764' // ❤
```

### String
Sequência de caracteres. Aspas duplas. Kotlin tem dois tipos:
```kotlin
// String simples
val texto = "Olá, mundo!"

// String literal/raw (aceita quebras de linha e caracteres especiais)
val multiline = """
    Primeira linha
    Segunda linha
    Terceira linha
""".trimIndent()
```

#### Interpolação de strings
```kotlin
val nome = "Davidson"
val idade = 25
println("Meu nome é $nome e tenho $idade anos")
println("Dobro da idade: ${idade * 2}")  // expressão entre chaves
```

### Boolean
```kotlin
val ativo: Boolean = true
val inativo = false
```

---

## 3. Conversão de Tipos

Kotlin **não converte tipos implicitamente**. É preciso chamar a função de conversão explicitamente:

```kotlin
val inteiro = 42
val double = inteiro.toDouble()   // 42.0
val texto = inteiro.toString()    // "42"
val long = inteiro.toLong()

val numero = "123"
val convertido = numero.toInt()   // 123
```

Funções de conversão disponíveis: `.toByte()`, `.toShort()`, `.toInt()`, `.toLong()`, `.toFloat()`, `.toDouble()`, `.toChar()`, `.toString()`

### Métodos úteis de String
```kotlin
val s = "kotlin"
println(s.uppercase())         // KOTLIN
println(s.plus(" é legal"))    // kotlin é legal
println(s.length)              // 6
println(s.contains("kot"))     // true
```

---

## 4. Operadores Lógicos

### Operadores básicos
| Operador | Significado     | Exemplo           |
|----------|-----------------|-------------------|
| `&&`     | E lógico (AND)  | `a > 0 && b > 0`  |
| `\|\|`   | OU lógico (OR)  | `a > 0 \|\| b > 0`|
| `!`      | NÃO lógico (NOT)| `!ativo`          |

```kotlin
val a = 5
val b = 10
println(a > 0 && b > 0)   // true
println(a > 6 || b > 6)   // true
println(!true)             // false
```

### Comparação
```kotlin
println(a == b)   // false — igualdade de valor
println(a != b)   // true  — diferença
println(a >= b)   // false
println(a <= b)   // true
```

### Verificação de tipo: is / !is
```kotlin
val obj: Any = "texto"
println(obj is String)     // true
println(obj !is Int)       // true
```

### Verificação de intervalo: in / !in
```kotlin
val nota = 7
println(nota in 0..10)     // true
println(nota !in 5..6)     // true

val frutas = listOf("maçã", "banana")
println("banana" in frutas) // true
```

---

## 5. Operadores Matemáticos

### Aritméticos básicos
```kotlin
val a = 10
val b = 3
println(a + b)   // 13
println(a - b)   // 7
println(a * b)   // 30
println(a / b)   // 3   (divisão inteira!)
println(a % b)   // 1   (resto)
```

> Atenção: divisão entre Int resulta em Int. Use Double para divisão com decimais:
> `10.0 / 3` ou `10 / 3.0` resultam em `3.333...`

### Operadores de atribuição compostos
```kotlin
var x = 10
x += 5   // x = x + 5
x -= 3   // x = x - 3
x *= 2   // x = x * 2
x /= 4   // x = x / 4
x %= 3   // x = x % 3
```

### Math (biblioteca Java)
```kotlin
import kotlin.math.*

Math.round(3.7)      // 4L
Math.floor(3.9)      // 3.0
Math.ceil(3.1)       // 4.0
Math.pow(2.0, 10.0)  // 1024.0
Math.log10(1000.0)   // 3.0
Math.sqrt(16.0)      // 4.0
Math.abs(-5)         // 5
```

---

## 6. Estruturas Condicionais

### if / else
```kotlin
val temperatura = 30

if (temperatura > 25) {
    println("Está quente!")
} else if (temperatura in 15..25) {
    println("Temperatura agradável")
} else {
    println("Está frio!")
}
```

### if como expressão
Em Kotlin, `if` é uma expressão e pode retornar valor:
```kotlin
val max = if (a > b) a else b
println("O maior é $max")
```

### when — alternativa ao switch
```kotlin
val dia = 3
when (dia) {
    1 -> println("Segunda-feira")
    2 -> println("Terça-feira")
    3 -> println("Quarta-feira")
    4, 5 -> println("Quinta ou sexta")      // múltiplos valores
    in 6..7 -> println("Final de semana")   // intervalo
    else -> println("Dia inválido")
}
```

### when como expressão
```kotlin
val resultado = when {
    temperatura > 35 -> "Muito quente"
    temperatura > 25 -> "Quente"
    temperatura > 15 -> "Agradável"
    else -> "Frio"
}
```

### when com verificação de tipo (smart cast)
```kotlin
fun descrever(obj: Any): String = when (obj) {
    is Int -> "Número inteiro: $obj"
    is String -> "Texto: $obj"
    is Boolean -> "Booleano: $obj"
    else -> "Tipo desconhecido"
}
```

---

## 7. Controle de Exceções

### try / catch / finally
```kotlin
try {
    val resultado = 10 / 0
} catch (e: ArithmeticException) {
    println("Erro matemático: ${e.message}")
} finally {
    println("Este bloco sempre executa")
}
```

### Múltiplos catch (do mais específico ao mais genérico)
```kotlin
try {
    val texto = null
    println(texto!!.length)  // força NPE
} catch (e: NullPointerException) {
    println("Referência nula!")
} catch (e: IllegalArgumentException) {
    println("Argumento inválido!")
} catch (e: Exception) {
    println("Erro genérico: ${e.message}")
}
```

### throw — lançar exceções
```kotlin
fun validarIdade(idade: Int) {
    if (idade < 0) throw IllegalArgumentException("Idade não pode ser negativa")
    if (idade > 150) throw IllegalArgumentException("Idade inválida")
    println("Idade válida: $idade")
}
```

### try como expressão
```kotlin
val numero: Int? = try {
    "abc".toInt()
} catch (e: NumberFormatException) {
    null
}
```

### Exceções comuns em Kotlin/Java
| Exceção                    | Quando ocorre                      |
|----------------------------|------------------------------------|
| `ArithmeticException`      | Divisão por zero                   |
| `NullPointerException`     | Acesso a referência nula           |
| `NumberFormatException`    | Conversão inválida de string       |
| `ArrayIndexOutOfBoundsException` | Índice fora do array         |
| `IllegalArgumentException` | Argumento inválido para função     |
| `IllegalStateException`    | Estado inválido do objeto          |
