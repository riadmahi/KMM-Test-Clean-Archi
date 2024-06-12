package com.moment.hob.android.ui.settings.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.moment.hob.android.R
import com.moment.hob.android.ui.common.NavIndicatorBarOk
import com.moment.hob.android.ui.settings.EditProfileViewModel
import com.moment.hob.model.Profile
import com.moment.hob.state.ProfileUiState

@Composable
fun EditDisplayNameScreen(
    viewModel: EditProfileViewModel,
    onBack: () -> Unit
) {
    val profileUiState = viewModel.uiState.collectAsState()
    var profile: Profile? = (profileUiState.value as? ProfileUiState.Success)?.profile
    var displayNameText by rememberSaveable { mutableStateOf<String>(profile?.displayName?: "") }
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        NavIndicatorBarOk(
            text = "Change your display name",
            onBack = { onBack() },
            onSave = {
                profile?.let {
                    if (displayNameText.length > 3) {
                        viewModel.updateProfile(profile = profile.copy(displayName = displayNameText))
                    }
                    onBack()
                }
            }
        )
        if (profile != null) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(top = 48.dp),
                value = displayNameText,
                onValueChange = {
                    displayNameText = it
                },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.settings_section_about_display_name),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                },
                textStyle = MaterialTheme.typography.bodyMedium,
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.colors(
                    focusedTrailingIconColor = MaterialTheme.colorScheme.primary,
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                    cursorColor = MaterialTheme.colorScheme.primary,
                    focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    if (displayNameText.length > 3) {
                        viewModel.updateProfile(profile = profile.copy(displayName = displayNameText))
                    }
                })
            )
        }
    }
}