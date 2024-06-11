package com.moment.hob.android.ui.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.moment.hob.android.R
import com.moment.hob.android.ui.common.NavIndicatorBar

@Composable
fun EditProfileScreen(
    onNavigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        NavIndicatorBar(text = stringResource(id = R.string.profile_action_edit_profile)) { onNavigateBack() }
        Column(
            modifier = Modifier
                .weight(1F)
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            SettingSectionTitle(title = stringResource(id = R.string.settings_section_about_you))
            Spacer(modifier = Modifier.height(12.dp))
            SettingAction(
                name = stringResource(id = R.string.settings_section_about_display_name),
                filled = "Riad"
            )
            SettingAction(
                name = stringResource(id = R.string.settings_section_about_biography),
                filled = ""
            )
            SettingAction(
                name = stringResource(id = R.string.settings_section_about_birth_date),
                filled = ""
            )
        }

    }
}