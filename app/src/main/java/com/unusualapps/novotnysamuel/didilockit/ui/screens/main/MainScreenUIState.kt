package com.unusualapps.novotnysamuel.didilockit.ui.screens.main

sealed class MainScreenUIState{
    data class Success(val isLocked: Boolean, val timeOfLock: String) : MainScreenUIState()
    object Loading : MainScreenUIState()
}