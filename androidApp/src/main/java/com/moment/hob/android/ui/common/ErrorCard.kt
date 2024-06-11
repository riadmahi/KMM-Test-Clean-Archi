package com.moment.hob.android.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ErrorCard(
    modifier: Modifier = Modifier,
    cause: String
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 50.dp),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFEC3446)
        )
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 16.dp),
            text = cause,
            style = MaterialTheme.typography.labelMedium,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun ErrorCardPreview() = ErrorCard(cause = "Erreur introuvable")