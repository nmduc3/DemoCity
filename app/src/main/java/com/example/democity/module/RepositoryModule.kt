package com.example.democity.module

import com.example.democity.data.repository.WeatherRepository
import com.example.democity.data.source.WeatherDataSource
import org.koin.dsl.module

/**
 * Created by nmduc3 on 3/30/21
 */
val repositoryModule = module {
    single { WeatherDataSource(get()) }
    single { WeatherRepository(get()) }
}
