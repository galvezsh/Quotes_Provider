package com.galvezsh.quotes_provider.data.network

import com.galvezsh.quotes_provider.core.RetrofitHelper
import com.galvezsh.quotes_provider.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/** This class is responsible for making requests to the API **/
class QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()

    /**
     * This function executes the retrofit request in a coroutine (a separate thread),
     * fetching all quotes. Since 'body()' can return null, we specify with the elvis operator
     * that, if null, it returns an empty list.
     * **/
    suspend fun getAllQuotes(): List<QuoteModel>? {
        return withContext(
            context = Dispatchers.IO,
            block = {
                try {
                    retrofit.create( QuoteApiClient::class.java ).getAllQuotes().body() ?: emptyList()

                } catch (e: Exception) {
                    // IOException, no internet
                    null
                }
            }
        )
    }
}