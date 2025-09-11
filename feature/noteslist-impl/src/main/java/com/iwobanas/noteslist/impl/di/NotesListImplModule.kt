package com.iwobanas.noteslist.impl.di

import androidx.navigation3.runtime.entry
import com.iwobanas.core.navigation.EntryProviderInstaller
import com.iwobanas.core.navigation.Navigator
import com.iwobanas.notedetails.api.NoteDetailsKey
import com.iwobanas.noteslist.api.NotesListKey
import com.iwobanas.noteslist.impl.ui.NotesListScreen
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(ActivityRetainedComponent::class)
object NotesListImplModule {

    @IntoSet
    @Provides
    fun provideEntryProviderInstaller(navigator: Navigator): EntryProviderInstaller =
        {
            entry<NotesListKey> {
                NotesListScreen(onClick = { navigator.goTo(NoteDetailsKey(it)) })
            }
        }
}