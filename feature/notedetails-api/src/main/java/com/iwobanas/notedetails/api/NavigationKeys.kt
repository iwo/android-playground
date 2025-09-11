package com.iwobanas.notedetails.api

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data class NoteDetailsKey(val noteId: Int) : NavKey
