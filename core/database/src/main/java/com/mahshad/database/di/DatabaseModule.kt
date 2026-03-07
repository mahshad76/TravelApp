package com.mahshad.database.di

import android.content.Context
import androidx.room.Room
import com.mahshad.database.UserDao
import com.mahshad.database.UserDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DatabaseModule {
    @Provides
    @ViewModelScoped
    fun provideUserDatabase(@ApplicationContext context: Context): UserDataBase =
        Room.databaseBuilder(
            context,
            UserDataBase::class.java,
            UserDataBase.DATABASE_NAME
        ).build()

    @Provides
    @ViewModelScoped
    fun provideUserDao(userDataBase: UserDataBase): UserDao = userDataBase.userDao()
}