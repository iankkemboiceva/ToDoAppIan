package com.ian.todo.todoappian

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import db.ToDoTask
import viewmodels.ToDoListViewModel
import java.util.*


class MainActivity : AppCompatActivity() {

    private val viewModel: ToDoListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


addTask()
        getAllTasks()

    }

    fun addTask() {
        val task  = ToDoTask(
            1,
            "Content",
            "www.ian.com",
            "www.ian.com",
            Date(),
            false
        )
        viewModel.addToDo(task)
    }
    fun getAllTasks() {
        viewModel.getAllToDo()
    }
}