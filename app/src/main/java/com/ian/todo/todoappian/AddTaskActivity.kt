package com.ian.todo.todoappian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.ian.todo.todoappian.databinding.ActivityAddTaskBinding
import db.ToDoTask
import org.koin.androidx.viewmodel.ext.android.viewModel
import viewmodels.AddEditTaskViewModel
import viewmodels.ToDoListViewModel
import java.util.*

class AddTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding
    private val viewModel by viewModel<AddEditTaskViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_task)

        binding.viewModel = viewModel

        binding.btnadd.setOnClickListener(){

            val strtitle = binding.titleedit.text.toString()
            val conttitle = binding.descredit.text.toString()
            val imgurl = binding.descredit.text.toString()

            if (!strtitle.isNullOrBlank()){
                if (!conttitle.isNullOrBlank()){
                    val newtask = ToDoTask(null,strtitle,conttitle,imgurl, Date(),false)
                    viewModel.addToDo(newtask)
                    finish()
                    val intent = Intent(this, MainActivity::class.java)

                    startActivity(intent)

                }else{
                    showToast("Kindly enter a valid value for Description.This field is required")
                }
            }else{
                showToast("Kindly enter a valid value for Title.This field is required")
            }

        }
    }

    fun showToast(strmsg: String){
        Toast.makeText(applicationContext,strmsg, Toast.LENGTH_LONG).show()
    }
}