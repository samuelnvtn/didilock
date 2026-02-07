package com.unusualapps.novotnysamuel.didilockit.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val DarkBackground = Color(0xFF2F2D2D)
val Background = Color(0xFFF0FAEF)
val Locked = Color(0xFF69AE69)
val Unlocked = Color(0xFFEDCA77)
val DarkUnlock = Color(0xFF3B3B35)
val LightUnlock = Color(0xFFC4C4AF)
val DarkLock = Color(0xFF353B35)
val LightLock = Color(0xFFBCCEBC)

val lightTextColor = Color(0xFF2F2D2D)
val darkTextColor = Color(0xFFD7E0D6)

@Composable
fun textColor() = if (LocalAppDarkTheme.current) darkTextColor else lightTextColor

@Composable
fun backgroundColor() = if (LocalAppDarkTheme.current) DarkBackground else Background

@Composable
fun lockColor() = if (LocalAppDarkTheme.current) LightLock else DarkLock

@Composable
fun unlockColor() = if (LocalAppDarkTheme.current) LightUnlock else DarkUnlock

