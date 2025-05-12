package com.galvezsh.mvvm_1.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.galvezsh.mvvm_1.model.AdviceModel
import com.galvezsh.mvvm_1.model.AdviceProvider

class AdviceViewModel: ViewModel() {

    private val _adviceModel = MutableLiveData<AdviceModel>()
    val adviceModel: LiveData<AdviceModel> = _adviceModel

    init {
        randomAdvice()
    }

    fun randomAdvice() {
        _adviceModel.postValue( AdviceProvider.getRandomAdvice() )
    }

}