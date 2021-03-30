package com.example.democity.data.service

import com.example.democity.data.response.SearchLocationItem
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by nmduc3 on 3/30/21
 */
interface ApiService {
    @GET("api/location/search/")
    suspend fun searchLocationByText(@Query("query") query: String): List<SearchLocationItem>
}
