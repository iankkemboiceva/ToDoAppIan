package repositories

import androidx.lifecycle.LiveData

import db.AppDatabase
import db.ToDoTask
import db.ToDoTaskDao
import io.reactivex.Observable
import io.reactivex.Single






class ToDoRepo (private val todolistdao: ToDoTaskDao?) {





    fun addTask(task: ToDoTask) {
        todolistdao!!.insertToDoTask(task)
    }
    fun getloadAllTasks(): Single<List<ToDoTask>> {

        return todolistdao!!.getToDoTasks()
    }

    fun getloadTaskById(taskId: Long): ToDoTask {
        return todolistdao!!.getToDoTaskById(taskId)
    }

    fun deleteTasks(ToDoTask: ToDoTask) {
        todolistdao!!.deleteToDoTask(ToDoTask)
    }

    fun updateTaskById(task: ToDoTask) {
        todolistdao!!.updateToDoTask(task)
    }

    companion object {
        private val LOG_TAG = ToDoRepo::class.java
            .simpleName
    }
}

