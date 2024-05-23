package com.example.lab9.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.lab9.Entities.Note

@Dao
interface NoteDao {
    @Query ("SELECT * FROM notes")
    fun getAll(): List<Note>

    @Insert
    fun insert(note: Note)

    @Delete
    fun delete(note: Note)
}