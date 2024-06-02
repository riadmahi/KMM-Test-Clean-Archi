package com.moment.hob.android.ui.likes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.moment.hob.android.R
import com.moment.hob.android.ui.common.NotificationBadge
import com.moment.hob.android.ui.common.PremiumButton

@Composable
fun LikesScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        LikesHeader()
    }
}

@Composable
fun LikesHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.likes_header_name),
                style = MaterialTheme.typography.titleLarge
            )
            NotificationBadge(6)
        }
        Text(
            text = stringResource(id = R.string.likes_header_description),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.outline
        )
        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.BottomCenter) {
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                columns = GridCells.FixedSize(180.dp),
                contentPadding = PaddingValues(12.dp)
            )
            {
                item {
                    BlurredCard(photoUrl = "https://images.unsplash.com/photo-1714138667818-b545353d768a?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHwxfHx8ZW58MHx8fHx8")
                }
                item {
                    BlurredCard(photoUrl = "https://images.unsplash.com/photo-1714138667818-b545353d768a?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHwxfHx8ZW58MHx8fHx8")
                }
                item {
                    BlurredCard(photoUrl = "https://images.unsplash.com/photo-1714138667818-b545353d768a?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHwxfHx8ZW58MHx8fHx8")
                }
                item {
                    BlurredCard(photoUrl = "https://images.unsplash.com/photo-1714138667818-b545353d768a?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHwxfHx8ZW58MHx8fHx8")
                }
                item {
                    BlurredCard(photoUrl = "https://images.unsplash.com/photo-1714138667818-b545353d768a?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHwxfHx8ZW58MHx8fHx8")
                }
            }
            PremiumButton(
                modifier = Modifier.fillMaxWidth(0.8f),
                text = stringResource(id = R.string.become_premium)
            ) {

            }
        }
    }
}