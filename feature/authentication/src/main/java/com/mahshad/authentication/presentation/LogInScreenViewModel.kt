package com.mahshad.authentication.presentation

import androidx.lifecycle.ViewModel
import com.mahshad.data.UserRepository
import com.mahshad.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
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

    fun logInCheck(user: User): Flow<LogInState> =
        userRepository.getUsers().map { resultOfUsersList ->
            val users = resultOfUsersList.getOrElse { emptyList() }
            if (user in users && !users.isEmpty()) LogInState.Success else LogInState.Error(
                Throwable("Error!")
            )
        }
}

sealed interface LogInState {
    data object Success : LogInState
    data class Error(val e: Throwable) : LogInState
    data object Loading : LogInState
}