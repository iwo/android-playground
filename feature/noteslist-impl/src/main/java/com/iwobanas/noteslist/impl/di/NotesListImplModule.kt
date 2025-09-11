package com.iwobanas.noteslist.impl.di

import androidx.compose.material3.Text
import androidx.navigation3.runtime.entry
import com.iwobanas.core.navigation.EntryProviderInstaller
import com.iwobanas.noteslist.api.NotesListKey
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(ActivityRetainedComponent::class)
object NotesListImplModule {

    //TODO get navigator as parameter

    @IntoSet
    @Provides
    fun provideEntryProviderInstaller(): EntryProviderInstaller =
        {
            entry<NotesListKey> {
                Text("Modular screen")
            }
        }
}