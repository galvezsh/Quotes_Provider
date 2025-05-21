package com.galvezsh.quotes_provider.data

import com.galvezsh.quotes_provider.data.model.QuoteModel
import com.galvezsh.quotes_provider.data.model.QuoteProvider
import com.galvezsh.quotes_provider.data.network.QuoteService

/**
 * This class is responsible for selecting the
 * method with which we are going to extract the data,
 * whether it is done through the Internet (network),
 * through a local database, etc.
 * **/
class QuoteRepository {
    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel>? {
        val quotes = api.getAllQuotes()

        if ( quotes != null )
            QuoteProvider.quoteList = quotes
        return quotes
    }

//    TODO: Cambiar esto y sustituirlo. Si no hay datos en local, volver a solicitar a la API
    fun getRandomQuote(): QuoteModel {
        val quotes = QuoteProvider.quoteList

        return if ( quotes.isNotEmpty() )
            quotes[ quotes.indices.random() ]
        else
            QuoteModel("", "" )
    }
}