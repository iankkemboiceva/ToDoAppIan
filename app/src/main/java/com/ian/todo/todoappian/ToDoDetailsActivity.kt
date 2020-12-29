package com.ian.todo.todoappian

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import com.ian.todo.todoappian.databinding.ActivityDetailsBinding
import db.ToDoTask
import org.koin.androidx.viewmodel.ext.android.viewModel
import viewmodels.DetailsViewModel
import viewmodels.ToDoListViewModel


class ToDoDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    private val viewModel by viewModel<DetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)

        val data = intent.extras
        val todoresult = data?.getParcelable<ToDoTask>("task")

        binding.viewModel = viewModel
        viewModel.bind(todoresult!!)




    }


}
