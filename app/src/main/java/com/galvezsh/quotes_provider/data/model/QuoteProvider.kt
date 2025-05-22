package com.galvezsh.quotes_provider.data.model

import javax.inject.Inject
import javax.inject.Singleton

/** This class is responsible for storing all quotes in memory so they can be used later without having to make further requests to the API. **/
@Singleton // If this Singleton is not provided, when 'QuoteRepository' call this class, creates another instance, so, we lost the local data
class QuoteProvider @Inject constructor() {
    var quoteList = emptyList<QuoteModel>()
}