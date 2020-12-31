package utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


class Utility {

    fun convertDateToReadable(strdate: LocalDate){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            var formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
            var formattedDate = strdate.format(formatter)
        } else {
            TODO("VERSION.SDK_INT < O")
        }



    }
}