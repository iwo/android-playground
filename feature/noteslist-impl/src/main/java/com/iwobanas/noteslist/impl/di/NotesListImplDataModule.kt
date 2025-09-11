package com.iwobanas.noteslist.impl.di

import com.iwobanas.noteslist.api.NotesRepository
import com.iwobanas.noteslist.impl.data.NotesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class NotesListImplDataModule {
    @Binds
    abstract fun bindNotesRepository(impl: NotesRepositoryImpl): NotesRepository
}