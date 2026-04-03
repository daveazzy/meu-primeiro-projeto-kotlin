# Exercícios — Classes

---

## Classes Básicas

**Ex 1.** Crie uma classe `ContaBancaria` com:
- Propriedades: `titular: String`, `saldo: Double` (readonly externamente)
- Métodos: `depositar(valor: Double)`, `sacar(valor: Double): Boolean` (false se saldo insuficiente), `extrato(): String`
- Bloco `init` que valida que o saldo inicial não seja negativo

**Ex 2.** Crie uma classe `Aluno` com:
- Construtor primário: `nome: String`, `matricula: String`
- Construtor secundário que aceita apenas `nome` e gera matrícula automaticamente (ex: "ALU-${Random.nextInt(1000, 9999)}")
- Propriedade `notas: MutableList<Double>` inicializada vazia
- Método `adicionarNota(nota: Double)` com validação (0 a 10)
- Propriedade calculada `media: Double`
- Propriedade calculada `situacao: String` ("Aprovado", "Recuperação", "Reprovado")

**Ex 3.** Crie uma classe `Pilha<T>` (stack) com:
- `push(item: T)` — adiciona no topo
- `pop(): T?` — remove e retorna o topo (null se vazia)
- `peek(): T?` — retorna o topo sem remover
- `estaVazia(): Boolean`
- `tamanho: Int`

---

## Getters e Setters

**Ex 4.** Crie uma classe `Circulo` com:
- `var raio: Double` com setter que valida que não seja negativo
- `val area: Double` (getter calculado)
- `val perimetro: Double` (getter calculado)
- `val descricao: String` (getter que formata uma mensagem)

**Ex 5.** Crie uma classe `Temperatura` com:
- `var celsius: Double` com setter que valida >= -273.15
- `val fahrenheit: Double` (getter: celsius * 9/5 + 32)
- `val kelvin: Double` (getter: celsius + 273.15)
- Um método estático (companion) `deFahrenheit(f: Double): Temperatura`

**Ex 6.** Crie uma classe `Senha` com:
- `var valor: String` privada
- Um getter que retorna a senha mascarada (ex: "****")
- Um setter que valida: mínimo 8 caracteres, pelo menos uma letra e um número
- `fun verificar(tentativa: String): Boolean`

---

## Companion Object

**Ex 7.** Crie uma classe `IdGenerator` com companion object que:
- Mantém um contador privado
- Fornece `gerar(): String` que retorna IDs únicos no formato "ID-001", "ID-002"...
- Fornece `reset()` para reiniciar o contador

**Ex 8.** Crie uma classe `Configuracao` com companion object seguindo o padrão Singleton:
- `const val VERSAO = "1.0.0"`
- `var modoDebug: Boolean = false`
- `var urlBase: String = "https://api.exemplo.com"`
- `fun carregar(arquivo: String)` (simule a leitura)

**Ex 9.** Crie uma classe `Fracao(val numerador: Int, val denominador: Int)` com:
- Companion object com factory methods: `inteiro(n: Int)`, `metade()`, `umTerco()`
- Bloco init que valida denominador != 0
- Operador `toString()` no formato "3/4"
- Método `simplificar(): Fracao` (use MDC)

---

## Herança

**Ex 10.** Crie a hierarquia:
```
Veiculo (open)
├── Carro (open)
│   └── CarroEletrico
└── Moto
```
`Veiculo`: `marca`, `modelo`, `velocidadeMax`, método `descrever()` open
`Carro`: `numeroportas`, sobrescreve `descrever()`
`CarroEletrico`: `autonomiaKm`, sobrescreve `descrever()` chamando `super`
`Moto`: `temSidecar`, sobrescreve `descrever()`

**Ex 11.** Crie uma lista de `Veiculo` com instâncias de todos os tipos. Itere e chame `descrever()` em cada um — demonstre polimorfismo.

**Ex 12.** Em qual situação você usaria `super.metodo()`? Crie um exemplo prático.

---

## Data Classes

**Ex 13.** Crie `data class Produto(val id: Int, val nome: String, val preco: Double, val categoria: String)`.
- Crie 5 produtos de categorias diferentes
- Agrupe por categoria usando `groupBy`
- Encontre o produto mais caro por categoria
- Crie uma cópia do produto mais caro com desconto de 10%

**Ex 14.** Demonstre a diferença entre `==` e `===` para:
- Duas `data class` com os mesmos valores
- Duas classes normais com os mesmos valores

**Ex 15.** Crie um `data class Ponto(val x: Double, val y: Double)` com:
- Função `distancia(outro: Ponto): Double`
- Desestruturação: `val (x, y) = ponto`

---

## Singletons e Objetos

**Ex 16.** Crie um `object Logger` com níveis de log (INFO, WARN, ERROR) e um método para cada nível. Adicione um toggle `var ativo: Boolean` e histórico de mensagens.

**Ex 17.** Crie um `object ContadorVisitas` que:
- Mantém contagem por página: `Map<String, Int>`
- Método `registrar(pagina: String)`
- Método `relatorio(): String`

---

## Classes Aninhadas vs Internas

**Ex 18.** Crie uma classe `Arvore<T>`:
- `class No` (nested): tem `valor: T` e `filhos: List<No>`
- Método `inserir(valor: T)` na Arvore
- Método `buscar(valor: T): Boolean`

**Ex 19.** Crie uma classe `Formulario` com uma `inner class Campo`:
- `Campo` tem acesso ao `id` do formulário
- `Campo` tem `nome`, `valor`, `obrigatorio`
- `Formulario` tem `validar(): List<String>` que verifica campos obrigatórios

---

## Desafios

**Desafio A.** Banco completo: crie classes `Banco`, `Conta`, `Correntista` e `Transacao`. Implemente transferência entre contas, extrato com histórico, e relatório geral do banco.

**Desafio B.** Crie uma hierarquia de figuras geométricas com cálculo de área e perímetro. Use `data class` para as figuras e demonstre polimorfismo com uma lista de figuras.

**Desafio C.** Implemente um sistema de inventário usando `data class Item` com as operações de um CRUD (create, read, update, delete) usando coleções Kotlin e companion objects como factory.
