package utils

import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*


class Utility {

    companion object {

        fun convertDateToReadable(indate: Date): String? {
            var dateString: String? = null
            val sdfr = SimpleDateFormat("dd/MM/yyyy")

            try {
                dateString = sdfr.format(indate)
            } catch (ex: Exception) {
                println(ex)
            }
            return dateString
        }
    }
}