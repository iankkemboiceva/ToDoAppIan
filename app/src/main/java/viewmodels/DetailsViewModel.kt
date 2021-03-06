package viewmodels

import android.R
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import db.NoteTask
import repositories.NoteRepo
import utils.Utility


class DetailsViewModel(private val todorepo: NoteRepo): BaseViewModel() {
    private val  title = MutableLiveData<String>()
    private val content = MutableLiveData<String>()
    private val todourl = MutableLiveData<String>()
    private val updateddate = MutableLiveData<String>()




    fun bind(task: NoteTask){
        title.value = task.title
        content.value = task.content
        todourl.value = task.imgurl
        updateddate.value = Utility.convertDateToReadable(task.updateddate)

    }
    companion object {


        @BindingAdapter("fullimageUrl")
        @JvmStatic
        fun loadfullimage(imageView: ImageView, imageUrl: String?) {
            Glide.with(imageView.context).load(imageUrl)
                .placeholder(ColorDrawable(Color.GRAY))
                .apply(RequestOptions.centerCropTransform())

                .into(imageView)

        }

    }
    fun getTitle():MutableLiveData<String>{
        return title
    }

    fun getContent():MutableLiveData<String>{
        return content
    }
    fun getTodourl():MutableLiveData<String>{
        return todourl
    }
    fun getUpdateddate():MutableLiveData<String>{
        return updateddate
    }

    fun deleteNote(task: NoteTask) {

        todorepo.deleteTasks(task)
    }


}