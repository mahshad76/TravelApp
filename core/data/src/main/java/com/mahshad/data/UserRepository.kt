package com.mahshad.data

import com.mahshad.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun insertUser(user: User)
    suspend fun deleteUser(email: String)
    fun getUsers(): Flow<Result<List<User>>>
}