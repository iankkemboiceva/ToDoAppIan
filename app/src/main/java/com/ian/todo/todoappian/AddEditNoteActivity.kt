package com.ian.todo.todoappian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.ian.todo.todoappian.databinding.ActivityAddTaskBinding
import db.NoteTask
import org.koin.androidx.viewmodel.ext.android.viewModel
import viewmodels.AddEditTaskViewModel
import viewmodels.NoteListViewModel
import java.util.*

class AddEditNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding
    private lateinit var notes: NoteTask
    private val viewModel by viewModel<AddEditTaskViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_task)

        binding.viewModel = viewModel
        val data = intent
        if (data != null) {
            if (!data.getBooleanExtra("flagtoadd", false)) {
                notes = data.extras!!.getParcelable<NoteTask>("task")!!
                binding.titleedit.setText(notes.title)
                binding.descredit.setText(notes.content)
                binding.imgurledit.setText(notes.imgurl)
                binding.txtstatus.setText("MODIFY NOTE")
            } else {
                binding.txtstatus.setText("ADD NOTE")
            }
        }

        binding.btnadd.setOnClickListener() {

            val strtitle = binding.titleedit.text.toString()
            val conttitle = binding.descredit.text.toString()
            val imgurl = binding.imgurledit.text.toString()

            if (strtitle.isNotBlank()) {
                if (conttitle.isNotBlank()) {
                    if (data.getBooleanExtra("flagtoadd", false)) {
                        val newtask = NoteTask(null, strtitle, conttitle, imgurl, Date(), false)
                        viewModel.addNote(newtask)
                    } else {
                        val updatedtask =
                            NoteTask(notes.id, strtitle, conttitle, imgurl, Date(), true)
                        viewModel.editNote(updatedtask)

                    }
                    finish()
                    val intent = Intent(this, MainActivity::class.java)

                    startActivity(intent)

                } else {
                    showToast("Kindly enter a valid value for Description.This field is required")
                }
            } else {
                showToast("Kindly enter a valid value for Title.This field is required")
            }

        }
    }

    fun showToast(strmsg: String) {
        Toast.makeText(applicationContext, strmsg, Toast.LENGTH_LONG).show()
    }
}