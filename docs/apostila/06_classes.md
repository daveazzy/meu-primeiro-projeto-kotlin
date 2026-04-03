# Classes em Kotlin

## 1. Classe Básica

```kotlin
class Pessoa(val nome: String, var idade: Int) {
    fun apresentar() {
        println("Olá, sou $nome e tenho $idade anos.")
    }
}

val p = Pessoa("Davidson", 25)
p.apresentar()
println(p.nome)
p.idade = 26
```

### Construtor primário vs secundário
```kotlin
class Carro(val marca: String, val modelo: String) {
    var cor: String = "Branco"  // propriedade com valor padrão

    // Construtor secundário
    constructor(marca: String, modelo: String, cor: String) : this(marca, modelo) {
        this.cor = cor
    }
}

val c1 = Carro("Toyota", "Corolla")
val c2 = Carro("Honda", "Civic", "Preto")
```

### Bloco init
Executa durante a construção, pode validar parâmetros:
```kotlin
class Produto(val nome: String, val preco: Double) {
    init {
        require(preco >= 0) { "Preço não pode ser negativo" }
        require(nome.isNotBlank()) { "Nome não pode ser vazio" }
    }
}
```

### Modificadores de visibilidade
| Modificador | Visível para                              |
|-------------|-------------------------------------------|
| `public`    | Todos (padrão em Kotlin)                  |
| `private`   | Apenas dentro da classe                   |
| `protected` | Classe e subclasses                       |
| `internal`  | Mesmo módulo                              |

---

## 2. Getters e Setters

### Getter customizado
```kotlin
class Circulo(val raio: Double) {
    val area: Double
        get() = Math.PI * raio * raio   // calculado sempre que acessado

    val descricao: String
        get() = "Círculo com raio $raio"
}
```

### Setter customizado com validação
```kotlin
class Temperatura {
    var celsius: Double = 0.0
        set(value) {
            require(value >= -273.15) { "Temperatura abaixo do zero absoluto!" }
            field = value   // 'field' é o backing field (valor real armazenado)
        }

    val fahrenheit: Double
        get() = celsius * 9 / 5 + 32
}

val t = Temperatura()
t.celsius = 25.0
println(t.fahrenheit)   // 77.0
```

> O `field` representa o valor interno da propriedade. Sem ele, o setter cairia em recursão infinita ao tentar se atribuir.

---

## 3. Companion Object

Permite criar membros associados à **classe** em vez de instâncias, similar a `static` em Java:

```kotlin
class Banco {
    companion object {
        const val TAXA_JUROS = 0.05   // constante em tempo de compilação
        private var totalClientes = 0

        fun criarConta(nome: String): Conta {
            totalClientes++
            return Conta(nome, totalClientes)
        }

        fun getTotalClientes() = totalClientes
    }
}

// Acesso sem criar instância:
val conta = Banco.criarConta("Davidson")
println(Banco.TAXA_JUROS)
println(Banco.getTotalClientes())
```

### Companion como Factory
```kotlin
class Conexao private constructor(val url: String) {
    companion object {
        fun criar(host: String, porta: Int = 3306) = Conexao("$host:$porta")
        fun local() = Conexao("localhost:3306")
    }
}

val conn = Conexao.criar("servidor.com", 5432)
val local = Conexao.local()
```

---

## 4. Herança — Classes Abertas

Por padrão, classes Kotlin são **fechadas** (equivalente a `final` em Java). Use `open` para permitir herança:

```kotlin
open class Animal(open val nome: String) {
    open fun emitirSom() {
        println("$nome faz um som")
    }

    fun respirar() {   // não é open — não pode ser sobrescrito
        println("$nome respira")
    }
}

class Cachorro(override val nome: String) : Animal(nome) {
    override fun emitirSom() {
        println("$nome: Au au!")
    }

    fun buscarBola() {
        println("$nome busca a bola!")
    }
}

val dog = Cachorro("Rex")
dog.emitirSom()   // Rex: Au au!
dog.respirar()    // Rex respira
```

### Chamando a implementação do pai com super
```kotlin
class Gato(override val nome: String) : Animal(nome) {
    override fun emitirSom() {
        super.emitirSom()          // chama o pai
        println("$nome também: Miau!")
    }
}
```

### Blocar sobrescrita com final
```kotlin
open class Base {
    open fun metodo() { }
}

open class Filho : Base() {
    final override fun metodo() { }  // ninguém mais pode sobrescrever
}
```

---

## 5. Data Classes

Especializadas para armazenar dados. Geram automaticamente: `toString()`, `equals()`, `hashCode()`, `copy()` e funções de destructuring.

```kotlin
data class Usuario(
    val id: Int,
    val nome: String,
    val email: String
)

val u1 = Usuario(1, "Davidson", "dave@email.com")
println(u1)                    // Usuario(id=1, nome=Davidson, email=dave@email.com)

// equals() gerado automaticamente (por valor, não por referência)
val u2 = Usuario(1, "Davidson", "dave@email.com")
println(u1 == u2)              // true

// copy() — cria cópia com alguns campos alterados
val u3 = u1.copy(email = "novo@email.com")
```

### Destructuring (desestruturação)
```kotlin
val (id, nome, email) = u1
println("$id, $nome, $email")

// Em loops
val usuarios = listOf(u1, u2, u3)
for ((id, nome, _) in usuarios) {   // _ ignora campo
    println("$id: $nome")
}
```

### Restrições
- Deve ter pelo menos uma propriedade no construtor primário
- As propriedades devem ser `val` ou `var` (não pode ser apenas parâmetro)
- Não pode ser `abstract`, `open`, `sealed` ou `inner`

---

## 6. Singleton com object

`object` cria uma instância única. Não tem construtor:

```kotlin
object Configuracao {
    const val VERSAO = "1.0.0"
    var debug = false

    fun inicializar(modo: String) {
        debug = modo == "dev"
        println("App v$VERSAO iniciado (debug=$debug)")
    }
}

Configuracao.inicializar("dev")
println(Configuracao.debug)    // true
println(Configuracao.VERSAO)   // 1.0.0
```

### data object
Para singletons que precisam de `toString()` legível:
```kotlin
data object EstadoInicial
data object EstadoFinal

println(EstadoInicial)   // "EstadoInicial" em vez de hash aleatório
```

---

## 7. Classes Aninhadas (Nested)

Classe definida dentro de outra, mas **sem acesso** aos membros da classe externa:

```kotlin
class Computador(val marca: String) {
    class Processador(val modelo: String) {
        fun exibir() = println("Processador: $modelo")
        // NÃO pode acessar 'marca' do Computador
    }
}

// Instanciação sem precisar de instância externa:
val proc = Computador.Processador("Intel i9")
proc.exibir()
```

---

## 8. Classes Internas (Inner)

Com a palavra-chave `inner`, a classe **tem acesso** aos membros da classe externa:

```kotlin
class Carro(val modelo: String) {
    private var velocidade = 0

    inner class Motor {
        fun acelerar(velocidadeFinal: Int) {
            velocidade = velocidadeFinal   // acessa 'velocidade' do Carro
            println("$modelo acelerando para $velocidade km/h")
        }
    }
}

// Precisa de instância da classe externa:
val carro = Carro("Ferrari")
val motor = carro.Motor()
motor.acelerar(200)
```

### Quando usar nested vs inner?
- `nested class`: quando a lógica é relacionada mas independente da instância externa
- `inner class`: quando precisa acessar estado da instância externa
