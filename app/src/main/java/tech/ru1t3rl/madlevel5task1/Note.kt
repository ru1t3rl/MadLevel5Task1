package tech.ru1t3rl.madlevel5task1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "noteTable")
data class Note(
    @ColumnInfo(name = "title")
    var titleText: String,

    @ColumnInfo(name = "content")
    var contentText: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
)