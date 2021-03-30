package com.example.democity

import android.app.Application
import com.example.democity.module.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by nmduc3 on 3/30/21
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // Init DI
        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }
}
