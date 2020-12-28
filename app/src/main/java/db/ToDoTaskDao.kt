package db

import android.database.Observable
import androidx.lifecycle.LiveData
import androidx.room.*
import io.reactivex.Single


@Dao
interface ToDoTaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToDoTask(todotask: ToDoTask)

    @Update
    fun updateToDoTask(todotask: ToDoTask)

    @Delete
    fun deleteToDoTask(todotask: ToDoTask)

    @Query("SELECT * FROM todo WHERE title == :title")
    fun getToDoTaskByName(title: String): LiveData<List<ToDoTask>>

    @Query("SELECT * FROM todo WHERE id == :id")
    fun getToDoTaskById(id: Int): LiveData<ToDoTask>

    @Query("SELECT * FROM todo")
    fun getToDoTasks(): Single<List<ToDoTask>>
}