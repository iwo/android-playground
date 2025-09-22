package com.iwobanas.noteslist.api

import com.iwobanas.core.data.model.Note
import com.iwobanas.core.data.model.NoteId
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    val notes: Flow<List<Note>>

    suspend fun getNoteById(id: NoteId): Note?
}