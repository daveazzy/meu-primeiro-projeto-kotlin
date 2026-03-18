package aula_02_tipos_de_dados

fun main() {

    // # numericos

    // numero inteiro com 8 bits de resolução: -128 / 127
    val byte: Byte = 100

    // numero com 16 bits de resolução: -32768 / 32767
    // eu posso colocar um underline para que o numero fique legivel
    val short: Short = 32_500

    // numero com 32 bits de resolução: -2.147.483.648 / 2.147.483.647
    val int: Int = 2_000_317

    // numero com 64 bits de resolução: -9.223.372.036.854.775.808 / 9.223.372.036.854.775.807
    val long: Long = 2_000_317_987_897

    // ------------------------------------------------------------------------------------------------

    // # numericos de ponto flutuante

    // 32 bits de resolução
    val floar: Float  = 3f // -> precisa colocar a letra f no final

    // 64 bits de resolução
    val double: Double = 3.0 // -> nao precisa colocar nada ao final, porem se for representar um inteiro do tipo double, precisa colocar um .0 na frente

    // -------------------------------------------------------------------------------------------------

    // # tipos de dados literais (texto)

    val char: Char = 'c' // -> um UNICO caractere. precisa estar em aspas simples. pode ser maiusculo ou minusculo
    val string: String = """
        posso colocar 
        
        varios textos dessa forma 
        
        mas para isso eu preciso 
        
        colocar 3 aspas duplas
    """.trimIndent()

    val minorString: String = "posso fazer isso tambem para textos menores"

    val varString: String = "$char $minorString $byte" // -> tudo que vier pra cá será convertido em string

    // ---------------------------------------------------------------------------------------------------

    // boolean

    val boolean: Boolean = true


}