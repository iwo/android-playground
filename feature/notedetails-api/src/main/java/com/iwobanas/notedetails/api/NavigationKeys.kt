package com.iwobanas.notedetails.api

import androidx.navigation3.runtime.NavKey
import com.iwobanas.core.data.model.NoteId
import kotlinx.serialization.Serializable

@Serializable
data class NoteDetailsKey(val noteId: NoteId) : NavKey
