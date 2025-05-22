package com.galvezsh.quotes_provider.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galvezsh.quotes_provider.data.model.QuoteModel
import com.galvezsh.quotes_provider.domain.GetAllQuotesUseCase
import com.galvezsh.quotes_provider.domain.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase: GetAllQuotesUseCase,
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase

) : ViewModel() {

    private val _quoteModel = MutableStateFlow( QuoteModel("", "") )
    val quoteModel: StateFlow<QuoteModel> = _quoteModel

    private val _isLoading = MutableStateFlow( false )
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow( false )
    val error: StateFlow<Boolean> = _error

    init {
        viewModelScope.launch {
            _isLoading.value = true

            getQuotes()

            _isLoading.value = false
        }
    }

    fun randomQuote() {
        viewModelScope.launch {

            if ( _error.value ) {
                _error.value = false
                _isLoading.value = true
                getQuotes()

            } else {
                _isLoading.value = true
                _quoteModel.value = getRandomQuoteUseCase()

            }

            _isLoading.value = false
        }
    }

    private suspend fun getQuotes() {
        val result = getQuotesUseCase() // Calling here the invoke function

        if ( result != null ) {
            _quoteModel.value = result[0]
            _error.value = false

        } else {
            _error.value = true
        }
    }
}