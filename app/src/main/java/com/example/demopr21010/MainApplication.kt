package com.example.demopr21010

import android.app.Application
import com.example.demopr21010.di.appModule
import com.example.demopr21010.di.sourceModule
import com.example.demopr21010.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(appModule, viewModelModule,sourceModule))
        }
    }
}