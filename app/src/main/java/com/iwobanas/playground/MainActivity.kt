package com.iwobanas.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
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
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.iwobanas.core.navigation.EntryProviderInstaller
import com.iwobanas.noteslist.api.NotesListKey
import com.iwobanas.playground.data.NotesRepository
import com.iwobanas.core.data.model.Note
import com.iwobanas.playground.ui.theme.PlaygroundTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable
import javax.inject.Inject

@Serializable
data class NoteDetailsKey(val note: Note) : NavKey //TODO: use note ID after introducing ViewModels

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var notesRepository: NotesRepository

    @Inject
    lateinit var entryProviderBuilders: Set<@JvmSuppressWildcards EntryProviderInstaller>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaygroundTheme {
                val backStack = rememberNavBackStack(NotesListKey)

                NavDisplay(
                    backStack = backStack,
                    onBack = { backStack.removeLastOrNull() },
                    entryProvider = entryProvider {
                        /*entry<NotesListKey> {
                            val notes by notesRepository.notes.collectAsStateWithLifecycle(
                                emptyList(),
                                this@MainActivity
                            )
                            NotesList(
                                notes = notes,
                                onClick = { backStack.add(NoteDetailsKey(note = it)) })
                        }*/
                        entry<NoteDetailsKey> { key ->
                            NoteDetails(key.note)
                        }

                        entryProviderBuilders.forEach { builder -> this.builder() }
                    }
                )
            }
        }
    }
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
    PlaygroundTheme {
        NotesList(
            (1..5).map {
                Note(id = it, text = "Note $it")
            },
            onClick = {},
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