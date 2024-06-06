package com.moment.hob.android.ui.common

import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.moment.hob.android.ui.util.bounceClick

@Composable
fun DarkHobButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .bounceClick()
            .background(color = Color(0xFF3B3B3B),
                shape = ButtonDefaults.shape),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
    ) {
        Text(text = text, style = MaterialTheme.typography.labelMedium)
    }
}

@Composable
@Preview
fun DarkHobButtonPreview() = DarkHobButton(text = "Hello world") {}