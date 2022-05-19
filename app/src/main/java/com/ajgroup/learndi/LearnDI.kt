package com.ajgroup.learndi

import android.app.Application
import com.ajgroup.learndi.di.networkModule
import com.ajgroup.learndi.di.repositoryModule
import com.ajgroup.learndi.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class LearnDI:Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@LearnDI)
            modules(
                listOf(networkModule, repositoryModule, viewModelModule)
            )
        }
    }
}