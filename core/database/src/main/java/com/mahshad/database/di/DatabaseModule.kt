package com.mahshad.database.di

import android.content.Context
import androidx.room.Room
import com.mahshad.database.UserDao
import com.mahshad.database.UserDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext context: Context): UserDataBase =
        Room.databaseBuilder(
            context,
            UserDataBase::class.java,
            UserDataBase.DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun provideUserDao(userDataBase: UserDataBase): UserDao = userDataBase.userDao()
}