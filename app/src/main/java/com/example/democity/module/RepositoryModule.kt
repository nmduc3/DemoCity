package com.example.democity.module

import androidx.room.Room
import com.example.democity.common.Constant.Room.DATABASE_NAME
import com.example.democity.data.database.LocalDB
import com.example.democity.data.repository.LocalRepository
import com.example.democity.data.repository.WeatherRepository
import com.example.democity.data.source.WeatherDataSource
import org.koin.dsl.module

/**
 * Created by nmduc3 on 3/30/21
 */
val repositoryModule = module {
    single { WeatherDataSource(get()) }
    single { WeatherRepository(get()) }
    single { LocalRepository() }
}

val roomModule = module {
    single {
        Room.databaseBuilder(get(), LocalDB::class.java, DATABASE_NAME)
            .build()
    }
    single { get<LocalDB>().getSearchLocationItemDAO() }
}
