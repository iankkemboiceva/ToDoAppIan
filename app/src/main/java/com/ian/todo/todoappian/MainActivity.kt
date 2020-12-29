package com.ian.todo.todoappian

import adapter.ToDoListAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ian.todo.todoappian.databinding.ActivityMainBinding
import db.ToDoTask
import model.RecyclerViewCallback
import org.koin.androidx.viewmodel.ext.android.viewModel
import viewmodels.ToDoListViewModel
import java.util.*


class MainActivity : AppCompatActivity(), RecyclerViewCallback {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<ToDoListViewModel>()

    private var adapter: ToDoListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = viewModel
        initRecyclerView()
        observeData()

        getAllTasks()


    }

    fun addTask() {
        val task = ToDoTask(
            2,
            "Title",
            "Content",
            "https://cropnuts.com/wp-content/uploads/2019/09/drinking_water_bottle.jpg",
            Date(),
            false
        )
        viewModel.addToDo(task)
    }

    private fun initRecyclerView() {
        binding.recyclerview.setLayoutManager(LinearLayoutManager(this))

    }

    fun getAllTasks() {
        viewModel.getAllToDo()
    }

    private fun observeData() {
        viewModel.getToDoList()!!
            .observe(this, Observer<List<ToDoTask>> {
                    it ->
                adapter = ToDoListAdapter(it,this@MainActivity)
                adapter!!.setOnCallbackListener(this)
                binding.recyclerview.adapter = adapter

            })
    }

    override fun onRecycleViewItemClick(task: ToDoTask, position: Int) {
        TODO("Not yet implemented")
    }
}