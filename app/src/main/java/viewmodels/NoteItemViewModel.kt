package viewmodels

import android.R
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.View
import android.widget.ImageView

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import db.NoteTask
import utils.Utility


class NoteItemViewModel: BaseViewModel() {
    private val thumbnail = MutableLiveData<String>()
    private val title = MutableLiveData<String>()
    private val content = MutableLiveData<String>()
    private val updatedon = MutableLiveData<String>()
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    fun bind(todolist: NoteTask){
        thumbnail.value = todolist.imgurl
        title.value = todolist.title
        content.value = todolist.content
        if(todolist.booledit){
            loadingVisibility.value = View.VISIBLE
        }

        updatedon.value = Utility.convertDateToReadable(todolist.updateddate)

    }
    companion object {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun loadimage(imgview: ImageView, imageUrl: String?) {
            Glide.with(imgview.context).load(imageUrl)
                .placeholder(ColorDrawable(Color.GRAY))
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

    fun getUpdatedon():MutableLiveData<String>{
        return updatedon
    }

}