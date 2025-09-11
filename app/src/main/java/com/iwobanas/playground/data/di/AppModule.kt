package com.iwobanas.playground.data.di

import com.iwobanas.core.navigation.Navigator
import com.iwobanas.noteslist.api.NotesListKey
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object AppModule {
    @Provides
    @ActivityRetainedScoped
    fun provideNavigator(): Navigator = Navigator(startDestination = NotesListKey)
}