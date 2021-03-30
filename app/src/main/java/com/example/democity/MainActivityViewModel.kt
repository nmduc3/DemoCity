package com.example.democity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.democity.data.repository.LocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

/**
 * Created by nmduc3 on 3/30/21
 */
class MainActivityViewModel : ViewModel() {
    private val localRepo by inject(LocalRepository::class.java)

    internal fun clearCached() {
        viewModelScope.launch(Dispatchers.IO) {
            localRepo.clearCached()
        }
    }
}
