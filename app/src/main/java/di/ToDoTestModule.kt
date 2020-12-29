package di

import android.app.Application
import androidx.room.Room
import db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val roomTestModule = module {

    fun provideDB(application: Application): AppDatabase {
        return Room.inMemoryDatabaseBuilder(application, AppDatabase::class.java)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
    single { provideDB(androidApplication()) }

}