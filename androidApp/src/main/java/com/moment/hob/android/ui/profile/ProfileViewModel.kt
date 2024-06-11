package com.moment.hob.android.ui.profile

import androidx.lifecycle.ViewModel
import com.moment.hob.HobRepository

class ProfileViewModel(private val hobRepository: HobRepository): ViewModel() {

    val uiState = hobRepository.profileUiState
}