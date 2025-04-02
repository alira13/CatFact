package com.example.catfact.app

import android.app.Application
import com.example.catfact.di.appModule
import com.example.catfact.di.dataModule
import com.example.catfact.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}