package com.kirozh.smartschool

import android.app.Application
import com.kirozh.smartschool.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber
import timber.log.Timber.DebugTree

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MainApplication)
            modules(appModule)
        }
        if (BuildConfig.DEBUG) Timber.plant(DebugTree())
    }
}