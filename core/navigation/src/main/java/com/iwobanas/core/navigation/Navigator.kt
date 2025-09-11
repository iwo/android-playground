package com.iwobanas.core.navigation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavKey
import dagger.hilt.android.scopes.ActivityRetainedScoped

typealias EntryProviderInstaller = EntryProviderBuilder<NavKey>.() -> Unit

@ActivityRetainedScoped
class Navigator(startDestination: NavKey) {
    val backStack : SnapshotStateList<NavKey> = mutableStateListOf(startDestination)

    fun goTo(destination: NavKey){
        backStack.add(destination)
    }

    fun goBack(){
        backStack.removeLastOrNull()
    }
}