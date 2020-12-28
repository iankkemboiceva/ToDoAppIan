package ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import com.ian.todo.todoappian.R
import dagger.hilt.android.AndroidEntryPoint
import viewmodels.ToDoListViewModel

@AndroidEntryPoint
class ToDoListFragment : Fragment() {

    private val viewModel: ToDoListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_to_do_list, container, false)
    }


}