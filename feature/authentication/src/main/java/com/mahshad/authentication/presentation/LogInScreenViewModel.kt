package com.mahshad.authentication.presentation

import androidx.lifecycle.ViewModel
import com.mahshad.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LogInScreenViewModel @Inject constructor(private val userRepository: UserRepository) :
    ViewModel() {
    private val _emailStateFlow = MutableStateFlow<String>("")
    val emailStateFlow = _emailStateFlow.asStateFlow()

    private val _passwordStateFlow = MutableStateFlow<String>("")
    val passwordStateFlow = _passwordStateFlow.asStateFlow()

    fun updateEmailStateFlow(email: String) {
        _emailStateFlow.value = email
    }

    fun updatePasswordStateFlow(password: String) {
        _passwordStateFlow.value = password
    }
}