package com.galvezsh.quotes_provider.data.network

import com.galvezsh.quotes_provider.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

/** This interface is responsible for creating API requests **/
interface QuoteApiClient {

    @GET( "/v1/quotes/173" )
    suspend fun getAllQuotes(): Response< List<QuoteModel> >
}