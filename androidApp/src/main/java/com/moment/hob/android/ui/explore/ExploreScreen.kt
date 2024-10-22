package com.moment.hob.android.ui.explore

import androidx.compose.animation.core.SpringSpec
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.aghajari.compose.lazyswipecards.LazySwipeCards
import com.alexstyl.swipeablecard.Direction
import com.alexstyl.swipeablecard.ExperimentalSwipeableCardApi
import com.alexstyl.swipeablecard.rememberSwipeableCardState
import com.alexstyl.swipeablecard.swipableCard
import com.moment.hob.android.ui.explore.component.ReactionBar
import kotlinx.coroutines.launch

val listOfProfile = mutableListOf<String>(
    "https://images.unsplash.com/photo-1620195408655-90b26c8b9608?q=80&w=3387&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
    "https://images.unsplash.com/photo-1613001889603-529ca3f302e4?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fG11c2xpbSUyMHdvbWFufGVufDB8fDB8fHww"
)


@OptIn(ExperimentalSwipeableCardApi::class)
@Composable
fun ExploreScreen() {
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 12.dp),
        contentAlignment = Alignment.BottomCenter
    )
    {
        val state = rememberSwipeableCardState()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .swipableCard(
                    state = state,
                    onSwiped = { direction ->
                        println("The card was swiped to $direction")
                    },
                    onSwipeCancel = {
                        println("The swiping was cancelled")
                    }
                )
        ) {
            CardContent(photo = listOfProfile.first())
        }
        ReactionBar(
            onRollback = {},
            onSuperLike = {},
            onSwipeLeft = {
                scope.launch {
                    state.swipe(Direction.Left)
                }
            },
            onSwipeRight = {
                scope.launch {
                    state.swipe(Direction.Right)
                }
            }
        )
    }
}

@Composable
fun CardContent(
    photo: String
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp),
            shape = RoundedCornerShape(CornerSize(24.dp))
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = photo,
                contentDescription = "Profile photo",
                contentScale = ContentScale.Crop
            )
        }
    }
}
