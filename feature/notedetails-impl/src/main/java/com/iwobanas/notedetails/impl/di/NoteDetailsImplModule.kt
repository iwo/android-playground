package com.iwobanas.notedetails.impl.di

import androidx.navigation3.runtime.entry
import com.iwobanas.core.navigation.EntryProviderInstaller
import com.iwobanas.notedetails.api.NoteDetailsKey
import com.iwobanas.notedetails.impl.ui.NoteDetails
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(ActivityRetainedComponent::class)
object NoteDetailsImplModule {

    @IntoSet
    @Provides
    fun provideEntryProviderInstaller(): EntryProviderInstaller =
        {
            entry<NoteDetailsKey> { key ->
                NoteDetails(key.note)
            }
        }
}