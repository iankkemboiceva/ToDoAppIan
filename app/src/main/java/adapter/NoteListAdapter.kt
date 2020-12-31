package adapter

import android.content.Context
import android.content.res.ColorStateList
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.ian.todo.todoappian.R
import com.ian.todo.todoappian.databinding.ItemTodoBinding
import db.NoteTask
import model.RecyclerViewCallback
import viewmodels.NoteItemViewModel


class NoteListAdapter(private  var todolist:List<NoteTask>, val ct: Context): RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {


    var recyclerViewCallback: RecyclerViewCallback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteListAdapter.ViewHolder {
        val binding: ItemTodoBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_todo, parent, false)

        return ViewHolder(binding).apply {
            itemView.setOnClickListener {

              this@NoteListAdapter.recyclerViewCallback?.onRecycleViewItemClick(todolist[adapterPosition], adapterPosition)
            }
        }

    }

    override fun onBindViewHolder(holder: NoteListAdapter.ViewHolder, position: Int) {
        holder.bind(todolist[position])




    }

    fun setOnCallbackListener(recyclerViewCallback: RecyclerViewCallback) {
        this.recyclerViewCallback = recyclerViewCallback
    }

    override fun getItemCount(): Int {
        return todolist.size
    }

    fun updatePostList(todolst:List<NoteTask>){
        this.todolist = todolst

        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemTodoBinding): RecyclerView.ViewHolder(binding.root){
        private val viewModel = NoteItemViewModel()


        fun bind(task:NoteTask){
            viewModel.bind(task)
            binding.viewModel = viewModel



        }


    }

}