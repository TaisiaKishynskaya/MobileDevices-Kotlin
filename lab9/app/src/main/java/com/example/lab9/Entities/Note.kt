package com.example.lab9.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val text: String,
    val date: LocalDateTime = LocalDateTime.now()
) : Parcelable{
    val createdDateFormatted : String
        get() = date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
}
