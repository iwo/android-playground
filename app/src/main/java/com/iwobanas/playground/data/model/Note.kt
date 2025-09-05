package com.iwobanas.playground.data.model

import kotlinx.serialization.Serializable

@Serializable //TODO remove after adding ViewModels
data class Note(val id: Int, val text: String)

