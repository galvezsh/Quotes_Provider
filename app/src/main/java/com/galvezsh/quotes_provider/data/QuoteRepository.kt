package com.galvezsh.quotes_provider.data

import com.galvezsh.quotes_provider.data.model.QuoteModel
import com.galvezsh.quotes_provider.data.model.QuoteProvider
import com.galvezsh.quotes_provider.data.network.QuoteService
import javax.inject.Inject

/**
 * This class is responsible for selecting the
 * method with which we are going to extract the data,
 * whether it is done through the Internet (network),
 * through a local database, etc.
 * **/
class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private var quoteProvider: QuoteProvider
) {

    suspend fun getAllQuotes(): List<QuoteModel>? {
        val quotes = api.getAllQuotes()

        if ( quotes != null )
            quoteProvider.quoteList = quotes
        return quotes
    }

    fun getRandomQuote(): QuoteModel {
        val quotes = quoteProvider.quoteList

        return if ( quotes.isNotEmpty() )
            quotes[ quotes.indices.random() ]
        else
            QuoteModel("", "" )
    }
}