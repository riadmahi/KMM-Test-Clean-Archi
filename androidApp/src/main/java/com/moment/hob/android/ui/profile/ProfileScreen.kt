package com.moment.hob.android.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.moment.hob.android.R
import com.moment.hob.android.ui.common.PremiumButton
import com.moment.hob.android.ui.theme.WhiteSmoke
import com.moment.hob.model.Profile
import com.moment.hob.state.ProfileUiState

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel,
    navigateToEditProfile: () -> Unit
) {
    val uiState = viewModel.uiState
    val profile: Profile? = (uiState as? ProfileUiState.Success)?.profile
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        ProfileHeader(profile?.displayName ?: "")
        PremiumCard()
        ProfileActions(
            navigateToEditProfile = { navigateToEditProfile() }
        )
    }
}


@Composable
fun ProfileHeader(
    name: String
) {
    Column(
        modifier = Modifier.padding(top = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier
                .size(110.dp)
                .clip(RoundedCornerShape(150.dp)),
            model = "https://images.unsplash.com/photo-1700856417754-cb66c909f4d7?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8cHJvZmlsZSUyMHBob3RvfGVufDB8fDB8fHww",
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(text = name, style = MaterialTheme.typography.labelLarge)
    }
}

@Composable
fun PremiumCard() {
    Box(modifier = Modifier.fillMaxWidth(0.9f)) {
        Column {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.illustration_premium_card),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(25.dp))
        }
        PremiumButton(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            text = stringResource(id = R.string.upgrade)
        ) {}
    }
}

@Composable
fun ProfileActions(
    navigateToEditProfile: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(0.9f)
    ) {
        ProfileAction(title = stringResource(id = R.string.profile_action_edit_profile)) { navigateToEditProfile() }
        DefaultDivider()
        ProfileAction(title = stringResource(id = R.string.profile_action_manage_my_account)) {}
        DefaultDivider()
        ProfileAction(title = stringResource(id = R.string.profile_action_app_settings)) {}
        DefaultDivider()
        ProfileAction(title = stringResource(id = R.string.profile_action_contact_support)) {}
        DefaultDivider()
    }
}

@Composable
fun DefaultDivider() {
    Divider(
        color = WhiteSmoke,
        modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
    )
}