package com.example.democity.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.democity.data.database.dao.SearchLocationItemDAO
import com.example.democity.data.model.SearchLocationItem

/**
 * Created by nmduc3 on 3/30/21
 */
@Database(entities = [SearchLocationItem::class], version = 1)
abstract class LocalDB : RoomDatabase() {
    abstract fun getSearchLocationItemDAO(): SearchLocationItemDAO
}
