package com.example.democity.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


/**
 * Created by nmduc3 on 3/30/21
 */
@Entity(tableName = "search_location_item")
data class SearchLocationItem(
    @PrimaryKey
    @SerializedName("woeid") var woeid: Int? = null,

    @SerializedName("latt_long")
    @ColumnInfo(name = "latt_long")
    var lattLong: String? = null,

    @SerializedName("location_type")
    @ColumnInfo(name = "location_type")
    var locationType: String? = null,

    @SerializedName("title")
    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "query")
    var query: String? = null
)
