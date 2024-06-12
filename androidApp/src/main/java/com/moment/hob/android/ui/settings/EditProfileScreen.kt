package com.moment.hob.android.ui.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.moment.hob.HobRepository
import com.moment.hob.android.R
import com.moment.hob.android.ui.common.NavIndicatorBar
import com.moment.hob.android.ui.profile.DefaultDivider
import com.moment.hob.model.Profile
import com.moment.hob.state.ProfileUiState

@Composable
fun EditProfileScreen(
    viewModel: EditProfileViewModel,
    onNavigateBack: () -> Unit,
    onNavigateToEditName: () -> Unit,
) {
    val profileUiState = viewModel.uiState.collectAsState()
    val profile: Profile? = (profileUiState.value as? ProfileUiState.Success)?.profile
    if (profile != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            NavIndicatorBar(text = stringResource(id = R.string.profile_action_edit_profile)) { onNavigateBack() }
            Column(
                modifier = Modifier
                    .weight(1F)
                    .padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Spacer(modifier = Modifier.height(12.dp))
                SettingSectionTitle(title = stringResource(id = R.string.settings_section_about_you))
                Spacer(modifier = Modifier.height(6.dp))
                SettingAction(
                    name = stringResource(id = R.string.settings_section_about_display_name),
                    filled = profile.displayName,
                    onClick = {
                        onNavigateToEditName()
                    }
                )
                DefaultDivider()
                SettingAction(
                    name = stringResource(id = R.string.settings_section_about_biography),
                    filled = profile.biography,
                    onClick = { }
                )
                DefaultDivider()
                SettingAction(
                    name = stringResource(id = R.string.settings_section_about_birth_date),
                    filled = "18/12/2000",
                    onClick = { }
                )
                DefaultDivider()
                SettingAction(
                    name = stringResource(id = R.string.settings_section_about_origins),
                    filled = "Maroc, France",
                    onClick = { }
                )
                DefaultDivider()
                SettingAction(
                    name = stringResource(id = R.string.settings_section_about_languages),
                    filled = "Marocain (dialecte), Français, Anglais",
                    onClick = { }
                )
                DefaultDivider()
                SettingAction(
                    name = stringResource(id = R.string.settings_section_about_interests),
                    filled = "Football, Danse, Chant",
                    onClick = { }
                )
                DefaultDivider()
                SettingAction(
                    name = stringResource(id = R.string.settings_section_about_personalities),
                    filled = "Calme, Respectueux, Doux",
                    onClick = { }
                )
                DefaultDivider()

            }

        }
    }
}