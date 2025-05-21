package com.galvezsh.quotes_provider.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    /** Connect to the API using Retrofit **/
    fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl( "https://api.breakingbadquotes.xyz/" )
            .addConverterFactory( GsonConverterFactory.create() )
            .build()
    }
}