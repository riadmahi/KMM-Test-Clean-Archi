package com.moment.hob.android.ui.settings

import androidx.lifecycle.ViewModel
import com.moment.hob.HobRepository
import com.moment.hob.model.Profile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditProfileViewModel(private val hobRepository: HobRepository) : ViewModel() {
    val uiState = hobRepository.profileUiState

    fun updateProfile(profile: Profile) {
        CoroutineScope(Dispatchers.IO).launch {
            hobRepository.updateProfile(profile)
        }
    }
}