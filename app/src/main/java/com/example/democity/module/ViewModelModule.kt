package com.example.democity.module

import com.example.democity.MainActivityViewModel
import com.example.democity.listcity.ListCityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by nmduc3 on 3/30/21
 */
val viewModelModule = module {
    viewModel { MainActivityViewModel() }
    viewModel { ListCityViewModel() }
}
