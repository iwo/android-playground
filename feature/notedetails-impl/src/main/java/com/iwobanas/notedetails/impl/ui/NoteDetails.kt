package com.iwobanas.notedetails.impl.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iwobanas.core.data.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteDetails(note: Note) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Note details") }
            )
        }
    ) { paddingValues ->
        Text(
            text = note.text,
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
            Note(id = 123, text = "Very interesting note")
        )
    }
}