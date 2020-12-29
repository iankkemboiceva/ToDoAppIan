package db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Entity(tableName = "todo")
@Parcelize
data class ToDoTask(@PrimaryKey(autoGenerate = true) val id: Long?,
                       val title: String,
                      val content: String,
                      val imgurl: String,
                      @ColumnInfo(name = "updated_date")
                      val updateddate: Date,
                      val booledit: Boolean
): Parcelable