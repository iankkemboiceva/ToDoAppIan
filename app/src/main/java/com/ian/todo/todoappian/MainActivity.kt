package com.ian.todo.todoappian

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import db.ToDoTask
import org.koin.androidx.viewmodel.ext.android.viewModel
import viewmodels.ToDoListViewModel
import java.util.*


class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<ToDoListViewModel>()
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