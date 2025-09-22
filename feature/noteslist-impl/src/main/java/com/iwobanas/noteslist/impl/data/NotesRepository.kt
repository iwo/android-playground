package com.iwobanas.noteslist.impl.data

import com.iwobanas.core.data.model.Note
import com.iwobanas.core.data.model.NoteId
import com.iwobanas.noteslist.api.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class NotesRepositoryImpl @Inject constructor() : NotesRepository {

    private val sampleNotes = listOf(
        Note(id = NoteId(0), text = "Experiment with Kotlin Multiplatform"),
        Note(id = NoteId(1), text = "Try new Navigation 3"),
        Note(id = NoteId(2), text = "Modularize code"),
        Note(id = NoteId(3), text = "DI and modularization"),
        Note(id = NoteId(4), text = "Is Ktor any good?"),
    )

    override val notes: Flow<List<Note>> = flowOf(
        sampleNotes
    )

    override suspend fun getNoteById(id: NoteId): Note? {
        return sampleNotes.find { it.id == id }
    }

}