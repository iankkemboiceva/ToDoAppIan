package db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.time.LocalDate
import java.util.*

@Entity(tableName = "todo")
@Parcelize
data class NoteTask(@PrimaryKey(autoGenerate = true) val id: Long?,
                    var title: String,
                    val content: String,
                    val imgurl: String,
                    @ColumnInfo(name = "updated_date")
                      val updateddate: LocalDate,
                    val booledit: Boolean
): Parcelable