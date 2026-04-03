# Exercícios — Null Safety e Inicialização Tardia

---

## Tipos Nullable

**Ex 1.** Declare uma variável `String?` com o valor `null`. Tente acessar `.length` diretamente — o que acontece? Agora corrija usando verificação de null.

**Ex 2.** Crie uma função `obterNome(id: Int): String?` que retorna um nome se o id for par, ou `null` se for ímpar. Chame a função com os valores 2 e 3.

**Ex 3.** Dado um `String?`, use o operador `?.` para obter o tamanho da string. O que é retornado quando a string é null?

---

## Operador Elvis `?:`

**Ex 4.** Crie uma função `nomeMaiusculo(nome: String?): String` que retorna o nome em maiúsculas. Se o nome for null, retorna "ANÔNIMO". Use o operador Elvis.

**Ex 5.** Dado `val config: Map<String, String> = mapOf("tema" to "escuro")`, use `?.` e `?:` para obter o valor de `"idioma"` (que não existe), com default `"pt-BR"`.

**Ex 6.** Escreva uma função `somarSePositivo(a: Int?, b: Int?): Int` que:
- Retorna 0 se qualquer um dos valores for null
- Retorna a soma se ambos forem positivos
- Retorna 0 se algum for negativo

---

## Operador Non-null `!!`

**Ex 7.** Quando é seguro usar `!!`? Escreva um exemplo onde o uso de `!!` é aceitável e outro onde seria perigoso.

**Ex 8.** Dado `val texto: String? = "Kotlin"`, use `!!` para acessar `.length`. Depois mude para `null` e observe o resultado.

---

## Conversão Segura `as?`

**Ex 9.** Crie uma lista `listOf<Any>(1, "dois", 3.0, "quatro", 5)`. Use `as?` em um loop para imprimir apenas os elementos que são String.

**Ex 10.** Crie uma função `converterParaInt(obj: Any): Int?` que usa `as?` para tentar converter para Int sem lançar exceção.

---

## let com nullable

**Ex 11.** Dada uma lista de emails `List<String?>`, use `.let` para enviar email (imprimir "Enviando para: [email]") apenas para os não-nulos.

**Ex 12.** Crie uma cadeia de operações com `.let`:
```kotlin
val texto: String? = "  kotlin é incrível  "
```
Se não for null: remova espaços, converta para maiúsculas e imprima.

---

## lateinit

**Ex 13.** Crie uma classe `ServicoEmail` com uma propriedade `lateinit var remetente: String`. Crie um método `configurar(email: String)` que inicializa `remetente`. Crie outro método `enviar(destinatario: String)` que usa `remetente`. Tente chamar `enviar` antes de `configurar` e observe a exceção.

**Ex 14.** Adicione uma verificação com `::propriedade.isInitialized` no exercício anterior para evitar a exceção.

**Ex 15.** Por que não podemos usar `lateinit var` com `Int`? O que devemos usar no lugar?

---

## lazy

**Ex 16.** Crie uma propriedade `val dadosHeavy by lazy { }` que simula uma operação pesada (imprima "Carregando dados pesados..." dentro do lambda). Crie um programa que só acessa essa propriedade mediante condição e verifique que o carregamento ocorre apenas uma vez.

**Ex 17.** Explique a diferença entre:
```kotlin
val a: String = calcularValor()
val b: String by lazy { calcularValor() }
```

**Ex 18.** Crie uma classe `Configuracoes` com as seguintes propriedades lazy:
- `val conexaoBanco: String` — construída a partir de host + porta
- `val versaoApp: String` — lida de um "arquivo" (simule com uma string fixa)

---

## Desafios

**Desafio A.** Crie um mini sistema de usuário:
```kotlin
data class Usuario(val nome: String?, val email: String?, val idade: Int?)
```
Escreva uma função `validarUsuario(u: Usuario): List<String>` que retorna lista de erros (vazia se válido). Valide: nome não nulo e não vazio, email não nulo e contendo "@", idade entre 0 e 120.

**Desafio B.** Implemente uma classe `Cache<T>` com:
- `lateinit var _valor: T` (não é possível — use outro mecanismo)
- Uma propriedade `val valor: T?` que retorna null se não carregado
- Um método `carregar(valor: T)`
- Um método `limpar()`

**Desafio C.** Dada uma lista de strings que podem conter números ou texto misturado:
```kotlin
val entradas = listOf("42", "abc", null, "7", null, "xyz", "100")
```
Use null safety para somar apenas os valores que podem ser convertidos para Int. (Dica: `toIntOrNull()`)
