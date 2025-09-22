package com.iwobanas.notedetails.impl.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.iwobanas.core.data.model.Note
import com.iwobanas.core.data.model.NoteId
import com.iwobanas.notedetails.impl.viewmodel.NoteDetailsViewModel

@Composable
fun NoteDetailsScreen(
    noteId: NoteId,
    viewModel: NoteDetailsViewModel = hiltViewModel { factory: NoteDetailsViewModel.Factory ->
        factory.create(noteId.id)
    }
) {
    val note by viewModel.note.collectAsState(null)

    NoteDetails(note)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteDetails(note: Note?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Note details") }
            )
        }
    ) { paddingValues ->
        Text(
            text = note?.text ?: "Loading...",
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        )
    }
}

@Preview
@Composable
private fun NoteDetailsPreview() {
    MaterialTheme {
        NoteDetails(
            Note(id = NoteId(123), text = "Very interesting note")
        )
    }
}