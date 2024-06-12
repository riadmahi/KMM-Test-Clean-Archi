package com.moment.hob.android.ui.settings

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SettingSectionTitle(
    title: String
) {
    Text(
        text = title,
        color = Color.Black,
        style = MaterialTheme.typography.labelMedium
    )
}

@Composable
@Preview
fun SettingSectionTitlePreview() = SettingSectionTitle(title = "Titre")