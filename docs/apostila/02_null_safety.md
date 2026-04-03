# Null Safety e Inicialização Tardia

## 1. O Problema do Null

Em linguagens como Java, qualquer referência pode ser `null`, causando o temido `NullPointerException` em tempo de execução. Kotlin resolve isso no nível do sistema de tipos: **por padrão, nenhuma variável pode ser null**.

```kotlin
var nome: String = "Davidson"
// nome = null  // ERRO de compilação!
```

---

## 2. Tipos Nullable com `?`

Para permitir null, adicione `?` ao tipo:

```kotlin
var nome: String? = "Davidson"
nome = null  // OK agora

var numero: Int? = null
```

O compilador te força a tratar o caso null antes de usar a variável — isso elimina NPEs em tempo de compilação.

---

## 3. Verificação manual de null

A forma mais verbosa mas clara:
```kotlin
val texto: String? = obterTexto()

if (texto != null) {
    println(texto.length)  // aqui texto é automaticamente tratado como String (não nullable)
}
```

Esse comportamento é chamado de **smart cast**: dentro do bloco if, Kotlin sabe que `texto` não é null.

---

## 4. Operador de Chamada Segura `?.`

Executa a operação apenas se o valor não for null. Retorna null caso contrário:

```kotlin
val texto: String? = null
val tamanho = texto?.length    // null (não lança exceção)

// Encadeamento seguro
val cidade = usuario?.endereco?.cidade   // null se qualquer parte for null
```

---

## 5. Operador Elvis `?:`

Define um valor padrão para o caso null. Funciona como "se for null, use este valor":

```kotlin
val texto: String? = null
val tamanho = texto?.length ?: 0     // 0 se texto for null

val nome = usuario?.nome ?: "Anônimo"
```

O operador também pode lançar exceção:
```kotlin
val nome = usuario?.nome ?: throw IllegalStateException("Usuário sem nome")
```

---

## 6. Operador de Asserção Não-Null `!!`

**Perigoso!** Força o compilador a tratar o valor como não-null. Lança `NullPointerException` se o valor for null:

```kotlin
val texto: String? = null
val tamanho = texto!!.length  // lança NullPointerException!
```

Use `!!` apenas quando você tem **certeza absoluta** que o valor não é null e não há outra forma. Na maioria dos casos, prefira `?.` ou `?:`.

---

## 7. Conversão Segura `as?`

Tenta converter o tipo. Retorna null se a conversão falhar (em vez de lançar `ClassCastException`):

```kotlin
val obj: Any = "texto"
val numero: Int? = obj as? Int    // null (não é Int)
val texto: String? = obj as? String  // "texto"
```

---

## 8. Função `let` com nullable

`.let { }` executa o bloco apenas se o valor não for null. Dentro do bloco, `it` representa o valor não-null:

```kotlin
val email: String? = obterEmail()

email?.let {
    println("Email: $it")           // it é String (não nullable)
    enviarEmail(it)
}
```

Equivalente ao if-not-null, mas mais funcional e idiomático.

---

## 9. Resumo dos operadores de null

| Operador | Nome             | Comportamento                                  |
|----------|------------------|------------------------------------------------|
| `?`      | Nullable type    | Permite null no tipo                           |
| `?.`     | Safe call        | Executa só se não-null, retorna null se não    |
| `?:`     | Elvis operator   | Valor padrão para o caso null                  |
| `!!`     | Non-null assert  | Força não-null, lança NPE se null              |
| `as?`    | Safe cast        | Conversão segura, retorna null se falhar       |

---

## 10. lateinit var

Permite declarar uma propriedade `var` não-nullable sem inicializá-la imediatamente. Útil para injeção de dependência e frameworks de teste:

```kotlin
lateinit var conexaoBanco: ConexaoBanco

fun inicializar() {
    conexaoBanco = ConexaoBanco("localhost")
}

fun executar() {
    conexaoBanco.conectar()  // se não inicializado, lança UninitializedPropertyAccessException
}
```

**Restrições do `lateinit`:**
- Apenas para `var` (não `val`)
- Apenas para tipos de referência (não primitivos como Int, Double, Boolean)
- Apenas em classes (não em parâmetros de função)

### Verificar se foi inicializado
```kotlin
if (::conexaoBanco.isInitialized) {
    conexaoBanco.conectar()
}
```

---

## 11. by lazy { }

Inicialização preguiçosa: o valor é calculado apenas na primeira vez que é acessado. Perfeito para operações custosas que podem não ser necessárias:

```kotlin
val configuracao: Config by lazy {
    println("Carregando configuração...") // executado só na 1ª vez
    Config.carregarDoArquivo("config.json")
}

// configuracao ainda não foi inicializado aqui
println(configuracao.tema)    // AGORA é inicializado e "Carregando..." é impresso
println(configuracao.idioma)  // já inicializado, não imprime novamente
```

**Características do `lazy`:**
- Apenas para `val` (não `var`)
- Thread-safe por padrão
- Executa o lambda apenas uma vez, depois armazena o resultado em cache

---

## 12. Delegates.notNull()

Para casos onde você quer lazy initialization em tipos primitivos (que não suportam `lateinit`):

```kotlin
import kotlin.properties.Delegates

var temperaturaMaxima: Int by Delegates.notNull()

fun configurar() {
    temperaturaMaxima = 40
}
```

Se acessado antes de ser atribuído, lança `IllegalStateException`.

---

## 13. Quando usar cada um

| Situação | Solução recomendada |
|----------|---------------------|
| Pode ser null durante o ciclo de vida | `Type?` + `?.` e `?:` |
| Será inicializado antes do uso, tipo referência | `lateinit var` |
| Inicialização custosa, calculada uma vez | `val by lazy` |
| Tipo primitivo sem valor inicial | `Delegates.notNull()` |
