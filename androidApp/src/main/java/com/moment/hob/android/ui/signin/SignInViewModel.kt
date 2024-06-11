package com.moment.hob.android.ui.signin

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.moment.hob.HobRepository
import com.moment.hob.state.SignInUiState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignInViewModel(
    private val hobRepository: HobRepository,
) : ViewModel() {

    private var _uistate: MutableStateFlow<SignInUiState> = MutableStateFlow(SignInUiState.None)
    val uiState: StateFlow<SignInUiState> = _uistate.asStateFlow()


    fun signIn(email: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            _uistate.update { hobRepository.signIn(email, password) }
        }
    }
}