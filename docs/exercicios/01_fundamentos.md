# Exercícios — Fundamentos do Kotlin

---

## val e var

**Ex 1.** Declare uma variável `nome` imutável com seu nome e uma variável `pontos` mutável com valor 0. Incremente `pontos` em 10 e imprima o resultado.

**Ex 2.** Tente reatribuir uma `val`. O que acontece? Qual a mensagem de erro?

**Ex 3.** Declare as seguintes variáveis com tipo explícito:
- Um `Long` com o valor da população mundial (~8 bilhões)
- Um `Float` com o valor de PI aproximado
- Um `Boolean` chamado `logado` inicialmente `false`

---

## Tipos de Dados

**Ex 4.** Crie uma String multiline com as seguintes informações sobre você: nome, cidade e profissão. Use `trimIndent()` para remover a indentação.

**Ex 5.** Declare um `Int` usando separadores de milhar (underscores) para o número 1.500.000. Imprima seu valor.

**Ex 6.** O que acontece quando você divide dois Int em Kotlin? Crie um exemplo que demonstra a diferença entre divisão inteira e divisão com Double.

**Ex 7.** Crie uma String usando interpolação que mostre: "Olá! Sou [nome] e nasci em [anoNascimento]. Em 2030 terei [x] anos."

---

## Conversão de Tipos

**Ex 8.** Converta o número `3.99` (Double) para Int. Qual o resultado? É arredondado ou truncado?

**Ex 9.** Crie uma variável String com o valor `"42"` e converta-a para Int usando `.toInt()`. Depois tente converter `"abc"` para Int — o que acontece?

**Ex 10.** Crie um programa que recebe dois números como String e imprime a soma deles como número.

---

## Operadores Lógicos

**Ex 11.** Dada uma variável `temperatura: Int = 28`, use operadores lógicos para verificar:
- Está entre 20 e 35 (temperatura agradável)?
- Está abaixo de 0 OU acima de 40 (temperatura extrema)?

**Ex 12.** Verifique se o número 7 está no range `1..10` e se o número 15 está no range `1..10`.

**Ex 13.** Crie uma variável `Any` com o valor `"texto"`. Use `is` para verificar se é String, Int e Boolean.

---

## Operadores Matemáticos

**Ex 14.** Calcule o resultado de `Math.pow(2.0, 8.0)` e imprima: "2 elevado a 8 é igual a [resultado]".

**Ex 15.** Dado o número `3.7`, mostre o resultado de: `round`, `floor` e `ceil`.

**Ex 16.** Qual o resultado de `17 % 5`? Para que serve o operador `%` (módulo)?

**Ex 17.** Calcule e imprima as 5 primeiras potências de 2: 2¹, 2², 2³, 2⁴, 2⁵.

---

## Estruturas Condicionais

**Ex 18.** Escreva um programa que, dado um valor de nota (0 a 10), imprima:
- "Reprovado" se nota < 5
- "Recuperação" se nota entre 5 e 6 (exclusive)
- "Aprovado" se nota >= 6

**Ex 19.** Reescreva o exercício 18 usando `when` em vez de `if/else`.

**Ex 20.** Use `if` como expressão para atribuir a uma variável `status` o valor `"maior"`, `"menor"` ou `"igual"` comparando dois números.

**Ex 21.** Crie um `when` que, dado um `Any`, imprime uma mensagem diferente para: Int, String, Double, Boolean e qualquer outro tipo.

---

## Controle de Exceções

**Ex 22.** Escreva um programa que tenta converter a String `"abc"` para Int usando `toInt()`, captura a exceção e imprime uma mensagem amigável.

**Ex 23.** Crie uma função `dividir(a: Int, b: Int): Double` que lança `IllegalArgumentException` se `b` for zero.

**Ex 24.** Adicione um bloco `finally` ao exercício 22 que imprime "Operação de conversão encerrada." independente do resultado.

**Ex 25.** Escreva um programa que usa `try` como expressão para retornar o número convertido ou -1 em caso de falha.

---

## Desafios

**Desafio A.** Calculadora simples: crie um programa que recebe dois números e uma operação (`+`, `-`, `*`, `/`). Use `when` para executar a operação. Trate divisão por zero com exceção.

**Desafio B.** Verificador de ano bissexto: um ano é bissexto se divisível por 4, exceto se for divisível por 100, exceto se for também divisível por 400. Implemente usando operadores lógicos e condicionais.

**Desafio C.** Classificador de IMC: dado peso e altura, calcule o IMC (peso / altura²) e classifique usando `when`:
- < 18.5: Abaixo do peso
- 18.5–24.9: Normal
- 25–29.9: Sobrepeso
- 30–34.9: Obesidade grau I
- >= 35: Obesidade grau II/III
