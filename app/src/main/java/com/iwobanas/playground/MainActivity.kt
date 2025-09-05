package com.iwobanas.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.iwobanas.playground.data.NotesRepository
import com.iwobanas.playground.data.model.Note
import com.iwobanas.playground.ui.theme.PlaygroundTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var notesRepository: NotesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaygroundTheme {
                val notes by notesRepository.notes.collectAsStateWithLifecycle(emptyList(), this)
                NotesList(notes)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesList(notes: List<Note>) {
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
                Text(text = note.text)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NotesListPreview() {
    PlaygroundTheme {
        NotesList(
            (1..5).map {
                Note(id = it, text = "Note $it")
            }
        )
    }
}

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
    PlaygroundTheme {
        NoteDetails(
            Note(id = 123, text = "Very interesting note")
        )
    }
}