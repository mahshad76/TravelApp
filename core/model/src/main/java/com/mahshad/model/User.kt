package com.mahshad.model

data class User(
    val email: String,
    val password: String
)

fun User.toUserEntity(): UserEntity = UserEntity(
    this.email,
    this.password
)