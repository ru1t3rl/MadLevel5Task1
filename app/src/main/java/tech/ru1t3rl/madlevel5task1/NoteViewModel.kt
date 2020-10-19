package tech.ru1t3rl.madlevel5task1

import android.app.Application
import android.content.res.Resources
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class NoteViewModel(application: Application): AndroidViewModel(application) {
    private val noteRepository = NoteRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    val note = noteRepository.getNotepad()
    val error = MutableLiveData<String>()
    val success = MutableLiveData<Boolean>()

    fun updateNote(title: String, text: String) {
        val newNote =  Note(
            id = note.value?.id,
            titleText = title,
            lastUpdated = Date(),
            text = text
        )

        if(isNoteValid(newNote)){
            mainScope.launch {
                withContext(Dispatchers.IO){
                    noteRepository.updateNotepad(newNote)
                }
                success.value = true
            }
        }
    }

    private fun isNoteValid(note: Note): Boolean {
        return when{
            note.titleText.isBlank() -> {
                error.value = Resources.getSystem().getString(R.string.empty_title)
                    false
            }
            else -> return true
        }
    }
}