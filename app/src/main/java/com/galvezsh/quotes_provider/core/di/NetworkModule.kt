package com.galvezsh.quotes_provider.core.di

import com.galvezsh.quotes_provider.data.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn( SingletonComponent::class ) // Type Application, it means that the instance lifecycle is the same as a Application (lives until the application closes)
object NetworkModule {

    @Singleton // Specify that this function, when is created, the next time that other class needs a injection, send this SAME instance already created, instead of create another one
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl( "https://api.breakingbadquotes.xyz/" )
            .addConverterFactory( GsonConverterFactory.create() )
            .build()
    }

    @Singleton
    @Provides
    /**
     * In this function, because is a Provide function, the parameter Retrofit is automatically
     * provide by the last function, because 'provideRetrofit' is a function that returns a retrofit
     * object whenever is called, even in parameters */
    fun provideQuoteApiClient( retrofit: Retrofit ): QuoteApiClient {
        return retrofit.create( QuoteApiClient::class.java )
    }
}