package com.unusualapps.novotnysamuel.didilockit.ui.screens.main

sealed class MainScreenUIState{
    data class Success(val isLocked: Boolean) : MainScreenUIState()
    object Loading : MainScreenUIState()
}