package com.ian.todo.todoappian

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import com.ian.todo.todoappian.databinding.ActivityDetailsBinding
import db.NoteTask
import org.koin.androidx.viewmodel.ext.android.viewModel
import viewmodels.DetailsViewModel
import viewmodels.NoteListViewModel


class NoteDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    private lateinit var note: NoteTask
    private val viewModel by viewModel<DetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)

        val data = intent.extras
        note = data?.getParcelable<NoteTask>("task")!!

        binding.viewModel = viewModel
        binding.btnedit.setOnClickListener {
            val intent = Intent(this, AddEditNoteActivity::class.java)
            intent.putExtra("task", note)
            intent.putExtra("flagtoadd", false)
            startActivity(intent)
        }

        binding.btndelete.setOnClickListener {

            val builder = AlertDialog.Builder(this@NoteDetailsActivity)


            builder.setTitle("Delete Note")


            builder.setMessage("Are you sure you want to delete this note?")


            builder.setPositiveButton("YES") { dialog, which ->
                viewModel.deleteNote(note)
                finish()
                val intent = Intent(this, MainActivity::class.java)

                startActivity(intent)
            }


            // Display a neutral button on alert dialog
            builder.setNeutralButton("Cancel") { _, _ ->

            }

            // Finally, make the alert dialog using builder
            val dialog: AlertDialog = builder.create()

            // Display the alert dialog on app interface
            dialog.show()
        }
        viewModel.bind(note)


    }


}
