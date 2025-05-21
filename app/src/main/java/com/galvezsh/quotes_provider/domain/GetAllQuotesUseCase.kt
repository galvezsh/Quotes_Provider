package com.galvezsh.quotes_provider.domain

import com.galvezsh.quotes_provider.data.QuoteRepository
import com.galvezsh.quotes_provider.data.model.QuoteModel

class GetAllQuotesUseCase {
    private val repository = QuoteRepository()

    /** This function is called when the instance of the object uses the '()' at the end, like 'getQuoteUseCase()' **/
    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()
}