package com.galvezsh.quotes_provider.model

class QuoteProvider {
    companion object {
        private val quoteList = listOf(
            QuoteModel(
                quote = "La programación orientada a objetos es fascinate",
                author = "Galvezsh"
            ),
            QuoteModel(
                quote = "La IA nos devorara a todos",
                author = "Galvezsh"
            ),
            QuoteModel(
                quote = "La IA es el futuro",
                author = "Galvezsh"
            ),
            QuoteModel(
                quote = "Si has visto la saga Terminator, puede que nos espere un futuro incierto",
                author = "Anonimo"
            ),
            QuoteModel(
                quote = "La arquitectura 'Modelo vista vista-modelo' no es complicado",
                author = "Galvezsh"
            ),
            QuoteModel(
                quote = "El autodidactismo es posible si uno se esfuerza lo suficiente",
                author = "Galvezsh"
            )
        )

        fun getRandomQuote(): QuoteModel {
            val position = (0..5).random()
            return quoteList[position]
        }
    }
}