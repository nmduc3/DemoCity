package com.example.democity.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.democity.common.Event
import com.example.democity.data.response.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by nmduc3 on 3/30/21
 */

open class BaseViewModel : ViewModel() {
    private val progressLiveData = MutableLiveData<Boolean>()
    private val errorLiveData = MutableLiveData<Event<Unit>>()

    internal fun progressLiveData(): LiveData<Boolean> = progressLiveData

    internal fun errorLiveData(): LiveData<Event<Unit>> = errorLiveData

    protected fun <T> callApi(
        function: suspend () -> ResultWrapper<T>?
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            progressLiveData.postValue(true)
            handleError(function)
        }
    }

    protected suspend fun <T> handleError(function: suspend () -> ResultWrapper<T>?) {
        when (val response = function()) {
            is ResultWrapper.Success -> {
                progressLiveData.postValue(false)
            }
            else -> {
                errorLiveData.postValue(Event(Unit))
            }
        }
    }
}
