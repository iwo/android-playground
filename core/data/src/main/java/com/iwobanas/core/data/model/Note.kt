package com.iwobanas.core.data.model

import kotlinx.serialization.Serializable

@JvmInline
@Serializable
value class NoteId(val id: Int)

data class Note(val id: NoteId, val text: String)