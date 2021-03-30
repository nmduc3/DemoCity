package com.example.democity.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.democity.data.model.SearchLocationItem

/**
 * Created by nmduc3 on 3/30/21
 */
@Dao
interface SearchLocationItemDAO {

    @Query("SELECT * FROM search_location_item WHERE `query` = :query")
    fun getAllByQuery(query: String): List<SearchLocationItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg item: SearchLocationItem)

    @Query("DELETE FROM search_location_item")
    fun clearTable()
}
