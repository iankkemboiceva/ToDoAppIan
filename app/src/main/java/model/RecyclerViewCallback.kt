package model

import db.ToDoTask

interface RecyclerViewCallback {
    fun onRecycleViewItemClick(task: ToDoTask, position: Int)

}