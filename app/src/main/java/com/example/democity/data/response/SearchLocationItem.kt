package com.example.democity.data.response

import com.google.gson.annotations.SerializedName


/**
 * Created by nmduc3 on 3/30/21
 */
data class SearchLocationItem(
    @SerializedName("latt_long") var lattLong: String? = null,
    @SerializedName("location_type") var locationType: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("woeid") var woeid: Int? = null
)
