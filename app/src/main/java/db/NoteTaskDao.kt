package db

import android.database.Observable
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single


@Dao
interface NoteTaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNoteTask(todotask: NoteTask): Completable

    @Update
    fun updateNoteTask(todotask: NoteTask): Completable

    @Delete
    fun deleteNoteTask(todotask: NoteTask)

    @Query("SELECT * FROM todo WHERE title == :title")
    fun getNoteTaskByName(title: String): LiveData<List<NoteTask>>

    @Query("SELECT * FROM todo WHERE id == :id")
    fun getNoteTaskById(id: Long): NoteTask


    @VisibleForTesting
    @Query("SELECT * FROM todo")
    fun getNoteTasks(): Flowable<List<NoteTask>>
}