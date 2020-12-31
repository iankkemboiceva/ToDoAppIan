package viewmodels


import android.util.Log
import androidx.lifecycle.MutableLiveData
import db.NoteTask
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import repositories.NoteRepo


class NoteListViewModel(private val todorepo: NoteRepo) : BaseViewModel() {

    private val TAG = "NoteListViewModel"

    private val respse: MutableLiveData<List<NoteTask>> =
        MutableLiveData<List<NoteTask>>()

    fun getAllNote() {


        val disposable = todorepo.getloadAllTasks()

            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ todolist ->
                handleresult(todolist)

            }, { exception ->
Log.e(TAG, exception.toString())
            })

        addDisposable(disposable)
    }



    private fun handleresult(result: List<NoteTask>) {

        respse?.value = result
        Log.v(TAG, result[0].title)
    }

    fun getNoteList(): MutableLiveData<List<NoteTask>> {
        return respse
    }
}