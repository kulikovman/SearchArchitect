package com.searcharchitect.two.screen.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.searcharchitect.common.manager.ISettingsManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val settings: ISettingsManager,
) : ViewModel() {

    private var previousState: LoginState = LoginState.Default

    private val _state = MutableLiveData(previousState)
    val state: LiveData<LoginState> get() = _state


    fun onClickSignIn(login: String, password: String) {
        viewModelScope.launch {
            changeState(LoginState.Checking)

            val isCorrectCredentials = settings.isCorrectCredentials(login, password)
            changeState(previousState)

            if (isCorrectCredentials) {
                settings.saveCredentials(login, password)
                changeState(LoginState.OpenSearchScreen)
            } else changeState(LoginState.Error)
        }
    }

    private fun changeState(state: LoginState) {
        previousState = _state.value ?: LoginState.Default
        _state.value = state
    }

}