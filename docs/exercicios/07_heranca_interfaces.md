# Exercícios — Herança, Interfaces e Polimorfismo

---

## Classes Abstratas

**Ex 1.** Crie uma classe abstrata `Funcionario` com:
- Propriedades abstratas: `nome: String`, `salarioBase: Double`
- Método abstrato: `calcularSalario(): Double`
- Método concreto: `contracheque()` que imprime as informações formatadas
- Subclasses: `FuncionarioCLT` (FGTS 8%), `FuncionarioPJ` (sem benefícios), `Estagiario` (bolsa fixa sem encargos)

**Ex 2.** Crie uma abstração para um jogo:
```
abstract class EntidadeJogo
├── Jogador
├── Inimigo
│   ├── InimigoBasico
│   └── ChefeFinal
└── NPC
```
Cada entidade tem `nome`, `vida`, `atacar()` e `receber(dano: Int)`.

**Ex 3.** Por que não podemos instanciar uma classe abstrata diretamente? Demonstre o erro e explique.

---

## Interfaces

**Ex 4.** Crie as interfaces:
- `interface Serializavel { fun serializar(): String }`
- `interface Persistivel { fun salvar(); fun carregar(id: String) }`

Crie uma `data class Usuario` que implementa ambas.

**Ex 5.** Crie uma interface `Comparavel<T>` com:
- `fun comparar(outro: T): Int` — retorna negativo, 0, ou positivo
- `fun ehMaior(outro: T): Boolean` (implementação padrão usando `comparar`)
- `fun ehMenor(outro: T): Boolean` (implementação padrão)
- `fun ehIgual(outro: T): Boolean` (implementação padrão)

Implemente com `data class Produto(val nome: String, val preco: Double)`.

**Ex 6.** Demonstre conflito de implementação padrão de duas interfaces e como resolvê-lo:
```kotlin
interface Voador { fun mover() = println("Voando") }
interface Nadador { fun mover() = println("Nadando") }
class Pato : Voador, Nadador { /* resolva o conflito */ }
```

**Ex 7.** Crie uma interface `Transformavel<T>` com:
- `fun mapear(transformacao: (T) -> T): T`
- `fun filtrar(predicado: (T) -> Boolean): T?`
Implemente com uma classe que represente um valor que pode ser transformado.

---

## Objetos Anônimos

**Ex 8.** Crie uma interface `EventoClick { fun aoClicar(x: Int, y: Int) }`. Instancie-a com um objeto anônimo que imprime as coordenadas. Simule 3 cliques em posições diferentes.

**Ex 9.** Use objeto anônimo para implementar um `Comparator` customizado que ordena strings pelo comprimento, depois alfabeticamente para strings de mesmo tamanho:
```kotlin
val palavras = listOf("banana", "kiwi", "uva", "maçã", "abacaxi")
val ordenado = palavras.sortedWith(object : Comparator<String> {
    override fun compare(a: String, b: String): Int { /* ... */ }
})
```

**Ex 10.** Quando usar objeto anônimo vs lambda? Dê um exemplo de cada situação.

---

## Enums

**Ex 11.** Crie um `enum class Planeta` com os 8 planetas do sistema solar. Cada planeta tem:
- `massaRelativaATerra: Double` (a massa em relação à Terra)
- `fun pesoNoPlaneta(pesoNaTerra: Double): Double` (cálculo de peso)
Imprima o peso de uma pessoa de 80kg em cada planeta.

**Ex 12.** Crie um `enum class Direcao(val dx: Int, val dy: Int)` com NORTE, SUL, LESTE, OESTE. Implemente:
- `fun oposta(): Direcao`
- `fun virarEsquerda(): Direcao`
- `fun virarDireita(): Direcao`

**Ex 13.** Crie um `enum class MesDoAno` com todos os meses tendo:
- `numeroDias: Int` (considere que Fevereiro tem 28)
- `trimestre: Int` (1, 2, 3 ou 4)
- `fun proximoMes(): MesDoAno`

**Ex 14.** Use `when` exaustivo com enum para criar uma função `fun descricaoEstacao(mes: MesDoAno): String` que retorna a estação do ano (hemisfério sul).

---

## Sealed Classes

**Ex 15.** Crie uma sealed class para representar o resultado de uma operação de rede:
```kotlin
sealed class RespostaRede<out T> {
    data class Sucesso<T>(val dados: T, val statusCode: Int) : RespostaRede<T>()
    data class Erro(val codigo: Int, val mensagem: String) : RespostaRede<Nothing>()
    data class ErroRede(val causa: String) : RespostaRede<Nothing>()
    object Carregando : RespostaRede<Nothing>()
    object Cancelado : RespostaRede<Nothing>()
}
```
Crie uma função que processa cada caso com `when`.

**Ex 16.** Implemente uma máquina de estados com sealed class:
```kotlin
sealed class EstadoPlayer {
    object Parado
    data class Reproduzindo(val musica: String, val progresso: Int)
    data class Pausado(val musica: String, val progresso: Int)
    object Carregando
}
```
Crie funções `play()`, `pause()`, `stop()` que fazem transições válidas entre estados.

**Ex 17.** Crie uma sealed interface `Expressao` para uma calculadora de expressões:
```kotlin
sealed interface Expressao
data class Numero(val valor: Double) : Expressao
data class Soma(val esquerda: Expressao, val direita: Expressao) : Expressao
data class Subtracao(val esquerda: Expressao, val direita: Expressao) : Expressao
data class Multiplicacao(val esquerda: Expressao, val direita: Expressao) : Expressao
```
Implemente `fun avaliar(expr: Expressao): Double` recursivamente.

---

## Desafios

**Desafio A.** Sistema de notificações: crie uma hierarquia com `sealed class Notificacao` (Email, Push, SMS, WhatsApp). Cada tipo tem campos específicos. Crie um `NotificacaoService` com interface que envia cada tipo. Use `when` exaustivo para o dispatch.

**Desafio B.** Motor de regras: crie uma interface `Regra<T>` com `fun validar(valor: T): Boolean` e `val descricao: String`. Implemente regras para validar um formulário de cadastro usando objetos anônimos e crie uma função que aplica todas as regras e retorna os erros.

**Desafio C.** Árvore de expressões booleanas:
```kotlin
sealed interface Condicao
data class Comparacao(val campo: String, val operador: String, val valor: Any) : Condicao
data class E(val esquerda: Condicao, val direita: Condicao) : Condicao
data class Ou(val esquerda: Condicao, val direita: Condicao) : Condicao
data class Nao(val condicao: Condicao) : Condicao
```
Implemente `fun avaliar(condicao: Condicao, dados: Map<String, Any>): Boolean`.
