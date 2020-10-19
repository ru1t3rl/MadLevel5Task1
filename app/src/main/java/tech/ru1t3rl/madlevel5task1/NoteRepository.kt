package tech.ru1t3rl.madlevel5task1

import android.content.Context
import androidx.lifecycle.LiveData

class NoteRepository(context: Context) {
    private val noteDao: NoteDao

    init{
        noteDao = NotepadRoomDatabase.getDatabase(context)!!.noteDao()
    }

    fun getNotepad(): LiveData<Note?>{
        return noteDao.getNotepad()
    }

    suspend fun updateNotepad(note: Note){
        noteDao.updateNote(note)
    }
}