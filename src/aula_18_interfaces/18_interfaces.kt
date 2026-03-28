package aula_18_interfaces

// em uma interface, varios contratos podem ser levados às classes

data class Document(val text: String)

interface Printer {
    fun print(text: String): Document

    val printType: String
}

interface TextConverter {
    val defaultText: String
        get() = "Desconhecido"

    fun convert(text: String, printerType: String): String {
        return text.ifEmpty { defaultText }
    }
}

class PdfPrinter: Printer, TextConverter { // aqui entra a parte de heranças multiplas explicado acima
    override fun print (text: String): Document {
        convert(text, printType)

        println("PDF printing: $text")
        return Document(text)
    }

    override val printType = "PDF"

    // -------------------------

    override fun convert(text: String, printerType: String): String {
        println("PDF converting: $text to $printerType")
        return text
    }
}

class WordPrinter: Printer, TextConverter {
    override fun print(text: String): Document {
        convert(text, printType)

        println("Word printing: $text")
        return Document(text)
    }

    override val printType: String
        get() = "WORD"

    override fun convert(text: String, printerType: String): String {
        println("PDF converting: $text to $printerType")
        return text
    }

}

fun main () {
    val pdfPrinter = PdfPrinter()

    pdfPrinter.print("Hello Kotlin")

    val pdfDocument: Document = pdfPrinter.print("Hello Kotlin")

    println(pdfDocument)

    val wordPrinter = WordPrinter()
    val wordDocument: Document = wordPrinter.print("Hello Kotlin, FROM Word")

    println(wordDocument)
}