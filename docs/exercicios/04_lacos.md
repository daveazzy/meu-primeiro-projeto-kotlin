# Exercícios — Laços de Repetição

---

## for com ranges

**Ex 1.** Imprima os números de 1 a 20, mas:
- Números divisíveis por 3: imprima "Fizz"
- Números divisíveis por 5: imprima "Buzz"
- Números divisíveis por 3 e 5: imprima "FizzBuzz"
- Demais: imprima o número

**Ex 2.** Imprima a tabuada do 7 (de 1 a 10) usando `for` com range.

**Ex 3.** Use `downTo` e `step` para imprimir uma contagem regressiva de 100 a 0, pulando de 10 em 10.

**Ex 4.** Imprima um triângulo de asteriscos com 5 linhas:
```
*
**
***
****
*****
```

---

## forEach e forEachIndexed

**Ex 5.** Dada a lista `listOf("Kotlin", "Java", "Python", "Swift", "Go")`, imprima cada linguagem com seu número de posição no formato: `"1. Kotlin"`.

**Ex 6.** Refaça o exercício 5 usando `forEachIndexed`.

**Ex 7.** Dada a lista de preços, use `forEach` para somar todos os valores maiores que 50.

---

## while e do-while

**Ex 8.** Implemente o algoritmo de Collatz:
- Se n é par: n = n / 2
- Se n é ímpar: n = 3n + 1
- Repita até n = 1
- Conte e imprima quantos passos foram necessários para n = 27

**Ex 9.** Use `do-while` para criar um menu interativo simulado que:
- Mostra opções: 1-Adicionar, 2-Listar, 3-Sair
- Processa cada opção (imprimir o que faria)
- Para ao escolher 3
- (Simule as entradas com uma lista de valores)

**Ex 10.** Encontre o primeiro número a partir de 1 que seja divisível por 2, 3, 5 e 7 usando while.

---

## break e continue

**Ex 11.** Itere pelos números de 1 a 100 e pare (break) quando encontrar o primeiro número divisível por 13 e por 7 ao mesmo tempo.

**Ex 12.** Imprima os números de 1 a 50, mas pule (continue) os múltiplos de 3 e 7.

**Ex 13.** Crie uma busca linear: dada a lista `listOf(5, 3, 8, 12, 1, 7, 15, 4)` e o número alvo `12`, use `for` com `break` para encontrar e imprimir a posição do número.

---

## Laços aninhados e labels

**Ex 14.** Imprima a tabela de multiplicação completa (1 a 10 × 1 a 10) usando laços aninhados.

**Ex 15.** Implemente uma busca em matriz 3x3:
```kotlin
val matriz = arrayOf(
    arrayOf(1, 2, 3),
    arrayOf(4, 5, 6),
    arrayOf(7, 8, 9)
)
```
Encontre o valor `5` e, ao encontrar, use `break@label` para sair dos dois loops. Imprima a posição encontrada.

**Ex 16.** Use `continue@label` para imprimir apenas os pares de (i, j) onde `i != j` em dois loops aninhados de 1 a 3.

---

## repeat

**Ex 17.** Use `repeat` para imprimir os 10 primeiros números da sequência de Fibonacci.

**Ex 18.** Simule lançamentos de dados: use `repeat(1000)` e um número aleatório (`(1..6).random()`) para lançar um dado 1000 vezes. Conte quantas vezes cada face saiu e imprima as frequências.

---

## Desafios

**Desafio A.** Número primo: escreva uma função `ehPrimo(n: Int): Boolean` usando laço. Um número é primo se divisível apenas por 1 e por ele mesmo. Imprima todos os primos de 1 a 100.

**Desafio B.** Pirâmide de números:
```
    1
   121
  12321
 1234321
123454321
```
Use laços aninhados para gerar este padrão.

**Desafio C.** Jogo de adivinhação simulado: gere um número aleatório entre 1 e 100 (`(1..100).random()`). Simule tentativas com uma lista de chutes predefinida. Use loops para verificar cada chute e forneça feedback: "muito baixo", "muito alto" ou "acertou!". Imprima quantas tentativas foram necessárias.

**Desafio D.** Número de Armstrong: um número é Armstrong se a soma de seus dígitos, cada um elevado ao número de dígitos, é igual ao próprio número. Ex: 153 = 1³ + 5³ + 3³. Encontre todos os números de Armstrong entre 1 e 1000.
