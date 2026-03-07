package com.mahshad.data

import com.mahshad.database.UserDao
import com.mahshad.model.User
import com.mahshad.model.toUser
import com.mahshad.model.toUserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userDao: UserDao) : UserRepository {
    override suspend fun insertUser(user: User) = userDao.insertUser(user.toUserEntity())


    override suspend fun deleteUser(email: String) = userDao.deleteUser(email)

    override fun getUsers(): Flow<List<User>> = userDao.getUsers().map { it.map { it.toUser() } }
}