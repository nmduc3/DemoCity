package com.example.democity.data.source

import com.example.democity.data.model.SearchLocationItem
import com.example.democity.data.response.ResultWrapper
import com.example.democity.data.service.ApiService
import com.example.democity.extension.callApi

/**
 * Created by nmduc3 on 3/30/21
 */
class WeatherDataSource(private val apiService: ApiService) : IWeatherApi {
    override suspend fun searchLocationByText(query: String): ResultWrapper<List<SearchLocationItem>> =
        callApi {
            apiService.searchLocationByText(query).map { it.copy(query = query) }
        }
}
