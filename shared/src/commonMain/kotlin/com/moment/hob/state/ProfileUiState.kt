package com.moment.hob.state

import com.moment.hob.model.Profile

interface ProfileUiState {
    object None: ProfileUiState
    object Loading: ProfileUiState
    data class Success(val profile: Profile): ProfileUiState
    data class Error(val cause: String): ProfileUiState
}