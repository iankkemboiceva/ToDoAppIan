package viewmodels

import android.R
import android.content.Context
import android.content.res.ColorStateList
import android.util.Log
import android.widget.ImageView

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import db.ToDoTask



class ToDoItemViewModel: BaseViewModel() {
    private val thumbnail = MutableLiveData<String>()
    private val title = MutableLiveData<String>()
    private val content = MutableLiveData<String>()
  

    fun bind(todolist: ToDoTask){
        thumbnail.value = todolist.imgurl
        title.value = todolist.title
        content.value = todolist.content

    }
    companion object {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun loadimage(imgview: ImageView, imageUrl: String?) {
            Glide.with(imgview.context).load(imageUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(imgview)

        }


       
    }
    fun getThumbnail():MutableLiveData<String>{
        return thumbnail
    }

    fun getContent():MutableLiveData<String>{
        return content
    }
    fun getTitle():MutableLiveData<String>{
        return title
    }

}