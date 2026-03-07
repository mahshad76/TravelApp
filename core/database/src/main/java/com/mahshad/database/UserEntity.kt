package com.mahshad.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class UserEntity(
    @PrimaryKey
    @ColumnInfo("user_email")
    val email: String,
    @ColumnInfo("user_password")
    val password: String
) {
    companion object {
        val DEFAULT = UserEntity(
            "mahshadmahdavi464@gmail.com",
            password = "Helloworld77@"
        )
    }
}
