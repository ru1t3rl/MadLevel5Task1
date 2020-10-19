package tech.ru1t3rl.madlevel5task1

import androidx.room.TypeConverter
import java.util.Date

class TypeConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date?{
        return value?.let{Date(it)}
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long?{
        return date?.time
    }
}