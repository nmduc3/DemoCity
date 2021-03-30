package com.example.democity.data.repository

import com.example.democity.data.source.IWeatherApi
import com.example.democity.data.source.WeatherDataSource

/**
 * Created by nmduc3 on 3/30/21
 */
class WeatherRepository(private val dataSource: WeatherDataSource) : IWeatherApi {
    override suspend fun searchLocationByText(query: String) =
        dataSource.searchLocationByText(query)
}
