package com.galvezsh.quotes_provider.data.model

import com.google.gson.annotations.SerializedName

/** The name in 'SerializedName' is the name that exists in the API, while the 'val' names, are for the project itself **/
data class QuoteModel(
    @SerializedName("quote") val quote: String,
    @SerializedName("author") val author: String
)
