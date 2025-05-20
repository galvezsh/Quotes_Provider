package com.galvezsh.quotes_provider.viewModel

import androidx.lifecycle.ViewModel
import com.galvezsh.quotes_provider.model.QuoteModel
import com.galvezsh.quotes_provider.model.QuoteProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class QuoteViewModel: ViewModel() {

    private val _quoteModel = MutableStateFlow( QuoteProvider.getRandomQuote() )
    val quoteModel: StateFlow<QuoteModel> = _quoteModel

    fun randomAdvice() {
        _quoteModel.value = QuoteProvider.getRandomQuote()
    }

}