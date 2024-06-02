package com.moment.hob.android.ui.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.moment.hob.android.R
import com.moment.hob.android.ui.common.NotificationBadge

@Composable
fun ChatScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        ChatHeader()
        ChatBody()
    }
}

@Composable
fun ChatHeader() {
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
                text = stringResource(id = R.string.chat_header_name),
                style = MaterialTheme.typography.titleLarge
            )
            NotificationBadge(6)
        }
    }
}

@Composable
fun ColumnScope.ChatBody() {
    Column(modifier = Modifier.weight(1f)) {
        ChatCard()
        ChatCard()
        ChatCard()
        ChatCard()
    }
}