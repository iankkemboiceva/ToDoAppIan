package viewmodels


import android.util.Log
import androidx.lifecycle.MutableLiveData
import db.ToDoTask
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import repositories.ToDoRepo


class AddEditTaskViewModel(private val todorepo: ToDoRepo) : BaseViewModel() {

    private val TAG = "AddEditTaskViewModel"



    fun addToDo(task: ToDoTask) {

        todorepo.addTask(task)
    }


}