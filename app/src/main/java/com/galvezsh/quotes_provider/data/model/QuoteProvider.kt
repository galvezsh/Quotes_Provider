package com.galvezsh.quotes_provider.data.model

/** This class is responsible for storing all quotes in memory so they can be used later without having to make further requests to the API. **/
class QuoteProvider {
    companion object {
        var quoteList = emptyList<QuoteModel>()
    }
}