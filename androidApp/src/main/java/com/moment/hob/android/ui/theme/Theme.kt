package com.moment.hob.android.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView

private val ColorScheme = darkColorScheme(
    primary = Purple,
    onPrimary = Color.White,
    background = Color.White,
    outline = CadetBlue,
    primaryContainer = WhiteSmoke,
    onBackground = Color.Black,
    onSurface = Color.Black,
    surface = Color.White
)

@Composable
fun HobTheme(
    content: @Composable () -> Unit,
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = ColorScheme.background.toArgb()
        }
    }

    MaterialTheme(
        colorScheme = ColorScheme,
        typography = Typography,
        content = content
    )
}