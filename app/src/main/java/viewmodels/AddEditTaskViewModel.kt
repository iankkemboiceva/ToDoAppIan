package viewmodels


import android.util.Log
import androidx.lifecycle.MutableLiveData
import db.NoteTask
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import repositories.NoteRepo


class AddEditTaskViewModel(private val todorepo: NoteRepo) : BaseViewModel() {

    private val TAG = "AddEditTaskViewModel"



    fun addNote(task: NoteTask) {

        todorepo.addTask(task)
    }

    fun editNote(task: NoteTask) {

        todorepo.updateTask(task)
    }
}