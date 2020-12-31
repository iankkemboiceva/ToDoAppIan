package repositories

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData

import db.AppDatabase
import db.NoteTask
import db.NoteTaskDao
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single






class NoteRepo (private val notelistdao: NoteTaskDao?) {





    fun addTask(task: NoteTask) {
        notelistdao!!.insertNoteTask(task).blockingAwait()
    }

    fun getloadAllTasks(): Flowable<List<NoteTask>> {

        return notelistdao!!.getNoteTasks()
    }

    fun getloadTaskById(taskId: Long): NoteTask {
        return notelistdao!!.getNoteTaskById(taskId)
    }

    fun deleteTasks(NoteTask: NoteTask) {
        notelistdao!!.deleteNoteTask(NoteTask)
    }

    fun updateTask(task: NoteTask) {
        notelistdao!!.updateNoteTask(task).blockingAwait()
    }

    companion object {
        private val LOG_TAG = NoteRepo::class.java
            .simpleName
    }
}

