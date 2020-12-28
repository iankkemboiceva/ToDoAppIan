package viewmodels


import android.util.Log

import db.ToDoTask
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import repositories.ToDoRepo


class ToDoListViewModel ( private val todorepo: ToDoRepo): BaseViewModel() {

    private val TAG = "ToDoListViewModel"


    fun getAllToDo() {


        val disposable = todorepo.getloadAllTasks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ todolist -> handleresult(todolist)

        }, { exception ->

        })

        addDisposable(disposable)
    }

    fun addToDo(task: ToDoTask) {

todorepo.addTask(task)
    }

    private fun handleresult(result: List<ToDoTask>) {
        Log.v(TAG,result[0].title)
    }
}