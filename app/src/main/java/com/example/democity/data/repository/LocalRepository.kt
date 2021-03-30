package com.example.democity.data.repository

import com.example.democity.data.database.dao.SearchLocationItemDAO
import com.example.democity.data.model.SearchLocationItem
import org.koin.java.KoinJavaComponent.inject

/**
 * Created by nmduc3 on 3/30/21
 */
class LocalRepository {
    private val weatherDAO by inject(SearchLocationItemDAO::class.java)

    fun clearCached() {
        weatherDAO.clearTable()
    }

    fun getAllCityByQuery(query: String) = weatherDAO.getAllByQuery(query)

    fun insertAllCity(list: List<SearchLocationItem>) {
        weatherDAO.insertAll(*list.toTypedArray())
    }
}
