package com.unusualapps.novotnysamuel.didilockit.ui.screens.main

import BaseScreen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MainScreen(
){
    val viewModel = hiltViewModel<MainScreenViewModel>()

    val uiState by viewModel.mainScreenUIState.collectAsStateWithLifecycle()

    val isLocked = when (val s = uiState) {
        is MainScreenUIState.Success -> s.isLocked
        else -> false
    }

    BaseScreen(
        topBarText = "Did I Lock It?",
    ) { padding ->
        MainScreenContent(
            paddingValues = padding,
            isLocked = isLocked,
            onButtonClick = { viewModel.onButtonClick() },
        )
    }
}

@Composable
fun MainScreenContent(
    paddingValues: PaddingValues,
    isLocked: Boolean,
    onButtonClick: () -> Unit,
){
    Column(modifier = Modifier.padding(paddingValues)) {
        Button(onClick = onButtonClick) {
            Text(text = if (isLocked) "LOCKED" else "UNLOCKED")
        }
    }
}
