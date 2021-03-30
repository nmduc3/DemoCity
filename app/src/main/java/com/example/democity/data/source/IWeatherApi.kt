package com.example.democity.data.source

import com.example.democity.data.response.ResultWrapper
import com.example.democity.data.response.SearchLocationItem

/**
 * Created by nmduc3 on 3/30/21
 */
interface IWeatherApi {
    suspend fun searchLocationByText(query: String): ResultWrapper<List<SearchLocationItem>>
}
