package com.example.api_di.app

import android.app.Application
import com.example.api_di.BuildConfig
import com.example.api_di.api.ListApiModule
import com.example.api_di.di.appModule
import com.example.api_di.di.dataModule
import com.example.api_di.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@App) // Application context
            modules(listOf(ListApiModule, appModule, domainModule, dataModule))
        }
    }
}