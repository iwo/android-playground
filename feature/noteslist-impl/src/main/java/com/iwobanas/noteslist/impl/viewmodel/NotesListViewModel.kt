package com.iwobanas.noteslist.impl.viewmodel

import androidx.lifecycle.ViewModel
import com.iwobanas.noteslist.api.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class NotesListViewModel @Inject constructor(
    repository: NotesRepository
) : ViewModel() {

    val notes = repository.notes
}