package com.unusualapps.novotnysamuel.didilockit.ui.screens.main

import BaseScreen
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun MainScreen(

){
    BaseScreen(
        topBarText = "MainScreen"
    ) {
        MainScreenContent()

    }
}

@Composable
fun MainScreenContent(){
    Text("MainScreen")
}
