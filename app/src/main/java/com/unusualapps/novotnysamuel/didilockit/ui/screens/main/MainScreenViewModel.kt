package com.unusualapps.novotnysamuel.didilockit.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unusualapps.novotnysamuel.didilockit.datastore.IDataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(private val repository: IDataStoreRepository) : ViewModel(){

    val mainScreenUIState: StateFlow<MainScreenUIState> = repository.lockStatus
        .map { lockStatus -> MainScreenUIState.Success(lockStatus.isLocked, lockStatus.timeOfChange) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = MainScreenUIState.Loading
        )

    fun onButtonClick() {
        viewModelScope.launch {
            repository.toggleLock()
        }
    }
}