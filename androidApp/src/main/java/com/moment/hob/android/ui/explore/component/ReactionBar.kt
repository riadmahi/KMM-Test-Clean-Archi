package com.moment.hob.android.ui.explore.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moment.hob.android.R

@Composable
fun ReactionBar(
    onSwipeRight: () -> Unit,
    onSwipeLeft: () -> Unit,
    onSuperLike: () -> Unit,
    onRollback: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ReactionButton(
            icon = R.drawable.ic_rollback,
            gradient = listOf(Color(0xFF7FFF43), Color(0xFF31DD4D)),
            size = 45.dp,
            onClick = {
                onRollback()
            }
        )
        ReactionButton(
            icon = R.drawable.ic_next,
            gradient = listOf(Color(0xFFDED6E5), Color(0xFF7B777F)),
            size = 60.dp,
            onClick = {
                onSwipeLeft()
            }
        )
        ReactionButton(
            icon = R.drawable.ic_super_like,
            gradient = listOf(Color(0xFFCEFF43), Color(0xFFFFCC19)),
            size = 45.dp,
            onClick = {
                onSuperLike()
            }
        )
        ReactionButton(
            icon = R.drawable.ic_like,
            gradient = listOf(Color(0xFFEA75C2), Color(0xFFAF4BFF)),
            size = 60.dp,
            onClick = {
                onSwipeRight()
            }
        )
    }
}

@Composable
@Preview
fun ReactionBarPreview() = ReactionBar(
    onRollback = {},
    onSuperLike = {},
    onSwipeLeft = {},
    onSwipeRight = {}
)