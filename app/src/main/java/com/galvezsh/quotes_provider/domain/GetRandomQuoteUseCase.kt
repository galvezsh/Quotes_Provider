package com.galvezsh.quotes_provider.domain

import com.galvezsh.quotes_provider.data.QuoteRepository
import com.galvezsh.quotes_provider.data.model.QuoteModel

class GetRandomQuoteUseCase {

    private val repository = QuoteRepository()

    operator fun invoke(): QuoteModel = repository.getRandomQuote()
}