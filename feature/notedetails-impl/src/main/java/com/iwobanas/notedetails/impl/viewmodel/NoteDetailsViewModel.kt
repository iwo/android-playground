package com.iwobanas.notedetails.impl.viewmodel

import androidx.lifecycle.ViewModel
import com.iwobanas.core.data.model.Note
import com.iwobanas.core.data.model.NoteId
import com.iwobanas.noteslist.api.NotesRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@HiltViewModel(assistedFactory = NoteDetailsViewModel.Factory::class)
class NoteDetailsViewModel @AssistedInject constructor(
    repository: NotesRepository,
    // Assisted injection doesn't support value classes https://github.com/google/dagger/issues/4613
    @Assisted noteIdInt: Int
) : ViewModel() {

    val noteId = NoteId(noteIdInt)

    @AssistedFactory
    interface Factory {
        fun create(noteIdInt: Int): NoteDetailsViewModel
    }

    val note: Flow<Note?> = flow {
        emit(null)
        emit(repository.getNoteById(noteId))
    }
}