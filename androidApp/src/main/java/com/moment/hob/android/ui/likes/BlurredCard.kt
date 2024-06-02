package com.moment.hob.android.ui.likes

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun BlurredCard(
    photoUrl: String
) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .height(250.dp)
            .padding(6.dp),
        shape = RoundedCornerShape(14.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .blur(radiusX = 15.dp, radiusY = 15.dp),
            model = photoUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
@Preview
fun BlurredCardPreview() =
    BlurredCard("https://images.unsplash.com/photo-1620195408655-90b26c8b9608?q=80&w=3387&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")