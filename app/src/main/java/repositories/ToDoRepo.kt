package repositories

import androidx.lifecycle.LiveData

import db.AppDatabase
import db.ToDoTask
import db.ToDoTaskDao
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject





class ToDoRepo @Inject constructor(private val todolistdao: ToDoTaskDao?) {
    private var tasks: LiveData<List<ToDoTask>>? = null




    fun addTask(task: ToDoTask) {
        todolistdao!!.insertToDoTask(task)
    }
    fun getloadAllTasks(): Single<List<ToDoTask>> {

        return todolistdao!!.getToDoTasks()
    }

    fun getloadTaskById(taskId: Int): LiveData<ToDoTask> {
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

