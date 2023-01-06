package com.example.assesment.repository

import com.example.assesment.api.ApiInterface
import com.example.assesment.model.User
import com.example.assesment.model.UserDataModel

class BaseRepository( private val userApi: ApiInterface): ApiInterface {
    override suspend fun getUserData(page: Int): UserDataModel {
        return userApi.getUserData(page)
    }
}