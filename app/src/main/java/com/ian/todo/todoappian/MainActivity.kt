package com.ian.todo.todoappian

import adapter.NoteListAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ian.todo.todoappian.databinding.ActivityMainBinding
import db.NoteTask
import model.RecyclerViewCallback
import org.koin.androidx.viewmodel.ext.android.viewModel
import viewmodels.NoteListViewModel
import java.util.*


class MainActivity : AppCompatActivity(), RecyclerViewCallback {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<NoteListViewModel>()

    private var adapter: NoteListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = viewModel

        binding.fab.setOnClickListener {
            val intent = Intent(this, AddEditNoteActivity::class.java)
            intent.putExtra("flagtoadd", true)
            startActivity(intent)
        }
        initRecyclerView()
        observeData()

        getAllTasks()


    }



    private fun initRecyclerView() {
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

    }

    private fun getAllTasks() {
        viewModel.getAllNote()
    }

    private fun observeData() {
        viewModel.getNoteList()
            .observe(this, {
                    it ->
                adapter = NoteListAdapter(it,this@MainActivity)
                adapter!!.setOnCallbackListener(this)
                binding.recyclerview.adapter = adapter

            })
    }

    override fun onRecycleViewItemClick(task: NoteTask, position: Int) {
        val intent = Intent(this, NoteDetailsActivity::class.java)
        intent.putExtra("task", task)

        startActivity(intent)
    }


}