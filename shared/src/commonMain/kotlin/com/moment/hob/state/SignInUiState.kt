package com.moment.hob.state

interface SignInUiState {
    object Success: SignInUiState

    object Loading: SignInUiState

    object None: SignInUiState

    data class Error(val cause: String): SignInUiState
}