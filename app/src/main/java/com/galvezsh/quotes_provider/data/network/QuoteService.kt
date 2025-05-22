package com.galvezsh.quotes_provider.data.network

import com.galvezsh.quotes_provider.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/** This class is responsible for making requests to the API. Here, because the 'QuoteApiClient' is a
 * interface, we cannot put a @Inject there, so basically, Hilt search in the 'networkModule' any
 * function that return 'QuoteApiClient', and the return is injected in 'api' **/
class QuoteService @Inject constructor(
    private val api: QuoteApiClient
) {

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
                    api.getAllQuotes().body() ?: emptyList()

                } catch (e: Exception) {
                    // IOException, no internet
                    null
                }
            }
        )
    }
}