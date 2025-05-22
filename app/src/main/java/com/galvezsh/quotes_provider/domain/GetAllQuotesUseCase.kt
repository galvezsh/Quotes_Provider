package com.galvezsh.quotes_provider.domain

import com.galvezsh.quotes_provider.data.QuoteRepository
import com.galvezsh.quotes_provider.data.model.QuoteModel
import javax.inject.Inject

class GetAllQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
) {

    /** This function is called when the instance of the object uses the '()' at the end, like 'getQuoteUseCase()' **/
    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()
}