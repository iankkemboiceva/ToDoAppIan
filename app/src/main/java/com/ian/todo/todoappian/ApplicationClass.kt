package com.ian.todo.todoappian

import android.app.Application
import di.databaseModule
import di.repositoryModule
import di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import java.util.logging.Level

class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(org.koin.core.logger.Level.DEBUG)
            androidContext(this@ApplicationClass)
            modules(listOf(repositoryModule, viewModelModule,databaseModule))
        }
    }
}