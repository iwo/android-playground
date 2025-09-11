package com.iwobanas.noteslist.impl.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.iwobanas.core.data.model.Note
import com.iwobanas.noteslist.impl.viewmodel.NotesListViewModel


@Composable
fun NotesListScreen(
    viewModel: NotesListViewModel = viewModel()
) {
    val notes by viewModel.notes.collectAsState(emptyList())
    NotesList(
        notes = notes,
        onClick = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesList(
    notes: List<Note>,
    onClick: (Note) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Your notes") }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            items(items = notes) { note ->
                Card(onClick = { onClick(note) }) {
                    Text(text = note.text)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NotesListPreview() {
    MaterialTheme {
        NotesList(
            (1..5).map {
                Note(id = it, text = "Note $it")
            },
            onClick = {},
        )
    }
}