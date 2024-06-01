package com.moment.hob.android.ui.explore.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.moment.hob.android.R
import com.moment.hob.android.ui.util.bounceClick

@Composable
fun ReactionButton(
    @DrawableRes icon: Int,
    gradient: List<Color>,
    size: Dp,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(size)
            .bounceClick()
            .clickable (
                onClick = { onClick() },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
            .background(
                brush = Brush.verticalGradient(
                    colors = gradient
                ),
                shape = RoundedCornerShape(60.dp)
            )
            .border(
                2.dp,
                color = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(60.dp)
            )
            .padding(12.dp)
    ) {
        Icon(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview
@Composable
fun ReactionButtonPreview() = ReactionButton(
    icon = R.drawable.ic_like,
    gradient = listOf(Color(0xFFEA75C2), Color(0xFFAF4BFF)),
    size = 60.dp
) {

}