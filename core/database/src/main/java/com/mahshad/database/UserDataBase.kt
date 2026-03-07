package com.mahshad.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mahshad.model.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = true)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        val DATABASE_NAME = "user_db"
    }
}