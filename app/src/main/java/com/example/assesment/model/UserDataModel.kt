package com.example.assesment.model

data class UserDataModel(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User> = listOf()
)