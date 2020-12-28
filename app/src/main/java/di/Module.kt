package di

import android.app.Application
import androidx.room.Room
import db.AppDatabase
import db.ToDoTaskDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import repositories.ToDoRepo
import viewmodels.ToDoListViewModel


val viewModelModule = module {
    single { ToDoListViewModel(get()) }
}
val databaseModule = module {

    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "toDoDB")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }


    fun provideDao(database: AppDatabase): ToDoTaskDao {
        return database.todoDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }
}

val repositoryModule = module {
    fun provideToDoRepo( dao: ToDoTaskDao): ToDoRepo {
        return ToDoRepo( dao)
    }

    single { provideToDoRepo(get()) }
}