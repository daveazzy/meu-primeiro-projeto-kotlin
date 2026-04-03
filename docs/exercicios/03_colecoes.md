# Exercícios — Coleções

---

## Arrays

**Ex 1.** Crie um array com os dias da semana. Imprima usando `joinToString` com separador ` | ` e com prefixo `"Dias: "`.

**Ex 2.** Crie dois arrays: um com números pares de 1 a 10 e outro com ímpares de 1 a 10. Concatene-os e imprima.

**Ex 3.** Dado o array `arrayOf(5, 3, 8, 1, 9, 2)`, imprima o maior e o menor valor sem usar sort.

---

## Listas

**Ex 4.** Crie uma lista imutável com 5 nomes. Tente adicionar um 6º nome — o que acontece?

**Ex 5.** Crie uma `mutableListOf` com números de 1 a 10. Remova todos os pares. Imprima o resultado.

**Ex 6.** Dada a lista `listOf(3, 7, 2, 9, 1, 5, 8, 4, 6)`:
- Imprima o primeiro número maior que 5
- Imprima o último número menor que 5
- Verifique se todos são positivos
- Verifique se algum é maior que 8
- Conte quantos são maiores que 4

**Ex 7.** Dada a lista de nomes `listOf("Ana", "Bruno", "Carlos", "Amanda", "Daniel")`:
- Filtre apenas os que começam com "A"
- Ordene alfabeticamente
- Converta todos para maiúsculas
- Faça tudo em uma única cadeia de operações

**Ex 8.** Use `mapIndexed` para transformar uma lista de nomes em uma lista de strings no formato `"1. Ana"`, `"2. Bruno"`, etc.

**Ex 9.** Dada a lista `listOf(1, 2, 3, 4, 5)`, use `zip` para combiná-la com `listOf("um", "dois", "três", "quatro", "cinco")` e imprima os pares.

**Ex 10.** Crie uma lista de listas (matriz) 3x3 representando um tabuleiro de jogo da velha. Preencha com "X", "O" e " ". Imprima o tabuleiro formatado.

---

## Sets

**Ex 11.** Dada a lista `listOf(1, 2, 3, 2, 1, 4, 3, 5)`, converta para Set e imprima. Quantos elementos únicos existem?

**Ex 12.** Crie dois sets de linguagens de programação conhecidas por dois desenvolvedores. Calcule:
- Linguagens que ambos conhecem (interseção)
- Todas as linguagens conhecidas (união)
- Linguagens que só o primeiro conhece (diferença)

**Ex 13.** Qual a diferença entre `hashSetOf`, `linkedSetOf` e `sortedSetOf`? Crie um exemplo com os mesmos elementos e compare a saída.

---

## Maps

**Ex 14.** Crie um mapa com os países e suas capitais (pelo menos 5). Imprima todas as capitais em ordem alfabética.

**Ex 15.** Dado o mapa `mapOf("a" to 1, "b" to 2, "c" to 3)`:
- Acesse o valor da chave `"b"`
- Tente acessar a chave `"z"` com valor padrão 0
- Verifique se contém a chave `"c"`
- Verifique se contém o valor `5`

**Ex 16.** Crie um mapa mutável de estoque: `produto -> quantidade`. Implemente operações de:
- Adicionar produto
- Atualizar quantidade
- Remover produto
- Listar produtos com estoque baixo (quantidade < 10)

**Ex 17.** Dada a lista de palavras `listOf("banana", "maçã", "abacaxi", "melão", "abacate", "manga")`, crie um Map onde a chave é a letra inicial e o valor é uma lista de palavras com aquela inicial. (Dica: `groupBy`)

---

## Operações avançadas em coleções

**Ex 18.** Dada a lista de transações financeiras:
```kotlin
data class Transacao(val tipo: String, val valor: Double)
val transacoes = listOf(
    Transacao("entrada", 1500.0),
    Transacao("saida", 200.0),
    Transacao("entrada", 800.0),
    Transacao("saida", 350.0),
    Transacao("entrada", 2000.0)
)
```
Calcule:
- Total de entradas
- Total de saídas
- Saldo final

**Ex 19.** Use `flatMap` para transformar `listOf(listOf(1,2,3), listOf(4,5,6), listOf(7,8,9))` em uma única lista plana.

**Ex 20.** Dada a lista de strings, use `partition` para separar em duas listas: as que têm mais de 5 caracteres e as que têm 5 ou menos.

---

## Desafios

**Desafio A.** Frequência de caracteres: dada uma String, crie um Map com cada caractere e quantas vezes ele aparece. Ordene pelo mais frequente.

**Desafio B.** Ranking de notas: dada uma lista de pares `(nome, nota)`, crie um ranking ordenado por nota (maior primeiro). Imprima o ranking com posição.

**Desafio C.** Agenda de contatos: implemente um sistema simples usando `MutableMap<String, MutableList<String>>` onde a chave é o nome e o valor é uma lista de telefones. Implemente: adicionar contato, adicionar telefone a contato existente, buscar contato, remover contato, listar todos.
