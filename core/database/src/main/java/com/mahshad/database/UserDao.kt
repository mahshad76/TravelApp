package com.mahshad.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mahshad.model.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: UserEntity)

    @Query("Delete FROM users_table WHERE user_email = :email")
    suspend fun deleteUser(email: String)

    @Query("SELECT * FROM users_table")
    fun getUsers(): Flow<Result<List<UserEntity>>>
}