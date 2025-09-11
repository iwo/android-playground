package com.iwobanas.noteslist.impl.data

import com.iwobanas.core.data.model.Note
import com.iwobanas.noteslist.api.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class NotesRepositoryImpl @Inject constructor() : NotesRepository {

    private val sampleNotes = listOf(
        Note(id = 0, text = "Experiment with Kotlin Multiplatform"),
        Note(id = 1, text = "Try new Navigation 3"),
        Note(id = 2, text = "Modularize code"),
        Note(id = 3, text = "DI and modularization"),
        Note(id = 4, text = "Is Ktor any good?"),
    )

    override val notes: Flow<List<Note>> = flowOf(
        sampleNotes
    )

    override suspend fun getNoteById(id: Int): Note? {
        return sampleNotes.find { it.id == id }
    }

}