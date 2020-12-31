package model

import db.NoteTask

interface RecyclerViewCallback {
    fun onRecycleViewItemClick(task: NoteTask, position: Int)

}