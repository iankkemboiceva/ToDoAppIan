package di

import android.app.Application
import androidx.room.Room
import db.AppDatabase
import db.NoteTaskDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import repositories.NoteRepo
import viewmodels.AddEditTaskViewModel
import viewmodels.NoteListViewModel
import viewmodels.DetailsViewModel

val viewModelModule = module {
    single { NoteListViewModel(get()) }
    single { AddEditTaskViewModel(get()) }
    single { DetailsViewModel(get()) }
}
val databaseModule = module {

    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "toDoDB")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }


    fun provideDao(database: AppDatabase): NoteTaskDao {
        return database.notedao
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }
}

val repositoryModule = module {
    fun provideNoteRepo( dao: NoteTaskDao): NoteRepo {
        return NoteRepo( dao)
    }

    single { provideNoteRepo(get()) }
}