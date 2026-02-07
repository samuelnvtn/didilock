package com.unusualapps.novotnysamuel.didilockit.ui.screens.main

import BaseScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.unusualapps.novotnysamuel.didilockit.R
import com.unusualapps.novotnysamuel.didilockit.ui.theme.Locked
import com.unusualapps.novotnysamuel.didilockit.ui.theme.Unlocked
import com.unusualapps.novotnysamuel.didilockit.ui.theme.backgroundColor
import com.unusualapps.novotnysamuel.didilockit.ui.theme.darkTextColor
import com.unusualapps.novotnysamuel.didilockit.ui.theme.lockColor
import com.unusualapps.novotnysamuel.didilockit.ui.theme.textColor
import com.unusualapps.novotnysamuel.didilockit.ui.theme.unlockColor

@Composable
fun MainScreen(
){
    val viewModel = hiltViewModel<MainScreenViewModel>()

    val uiState by viewModel.mainScreenUIState.collectAsStateWithLifecycle()

    val isLocked = when (val s = uiState) {
        is MainScreenUIState.Success -> s.isLocked
        else -> false
    }

    val time = when (val s = uiState) {
        is MainScreenUIState.Success -> s.timeOfLock
        else -> "7.2.2026"
    }

    BaseScreen(
        topBarText = "Did I Lock It?",
    ) { padding ->
        MainScreenContent(
            paddingValues = padding,
            isLocked = isLocked,
            lastChange = time,
            onButtonClick = { viewModel.onButtonClick() },
        )
    }
}

@Composable
fun MainScreenContent(
    paddingValues: PaddingValues,
    isLocked: Boolean,
    lastChange: String,
    onButtonClick: () -> Unit,
){
    Column(modifier = Modifier
        .padding(paddingValues)
        .background(color = backgroundColor())
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(painterResource(if (isLocked) R.drawable.lock else R.drawable.unlock), "",
            modifier = Modifier.size(200.dp),
            colorFilter = ColorFilter.tint(if (isLocked) lockColor() else unlockColor())
        )

        Text(text = "Last change: $lastChange", color = textColor())

        Spacer(modifier = Modifier.padding(8.dp))


        Button(
            onClick = onButtonClick,
            colors = ButtonDefaults.buttonColors(containerColor = if (isLocked) Locked else Unlocked)
        )
        {
            Text(text = if (isLocked) "LOCKED" else "UNLOCKED", color = Color.White)
        }

    }
}
