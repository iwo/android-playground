package com.iwobanas.notedetails.api

import androidx.navigation3.runtime.NavKey
import com.iwobanas.core.data.model.Note
import kotlinx.serialization.Serializable

@Serializable
data class NoteDetailsKey(val note: Note) : NavKey //TODO: use note ID after introducing ViewModels
