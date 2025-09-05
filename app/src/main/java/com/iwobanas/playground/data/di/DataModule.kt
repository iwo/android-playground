package com.iwobanas.playground.data.di

import com.iwobanas.playground.data.NotesRepository
import com.iwobanas.playground.data.NotesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
//@InstallIn(ViewModelComponent::class)
@InstallIn(ActivityComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindNotesRepository(impl: NotesRepositoryImpl): NotesRepository
}