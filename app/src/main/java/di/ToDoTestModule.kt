package di

import android.app.Application
import androidx.room.Room
import db.AppDatabase
import db.ToDoTaskDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val roomTestModule = module {


    fun provideDB(application: Application): AppDatabase {
        return Room.inMemoryDatabaseBuilder(application, AppDatabase::class.java)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun provideDao(database: AppDatabase): ToDoTaskDao {
        return database.todoDao
    }


    single { provideDB(androidApplication())}
    single { provideDao(get()) }

}