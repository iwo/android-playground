package com.iwobanas.noteslist.api

import com.iwobanas.core.data.model.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    val notes: Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?
}