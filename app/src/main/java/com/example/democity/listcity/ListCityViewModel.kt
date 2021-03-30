package com.example.democity.listcity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.democity.base.BaseViewModel
import com.example.democity.common.Event
import com.example.democity.data.repository.WeatherRepository
import com.example.democity.data.response.ResultWrapper
import com.example.democity.data.response.SearchLocationItem
import org.koin.java.KoinJavaComponent.inject

/**
 * Created by nmduc3 on 3/30/21
 */
class ListCityViewModel : BaseViewModel() {
    companion object {
        private const val QUERY = "a"
    }

    private val repository by inject(WeatherRepository::class.java)
    private val resultLD = MutableLiveData<Event<List<SearchLocationItem>>>()

    init {
        firstLoad()
    }

    internal val resultObserver: LiveData<Event<List<SearchLocationItem>>> = resultLD

    private fun firstLoad() {
        callApi {
            val response = repository.searchLocationByText(QUERY)
            when (response) {
                is ResultWrapper.Success -> resultLD.postValue(Event(response.value))
                else -> resultLD.postValue(Event(null))
            }
            response
        }
    }
}
