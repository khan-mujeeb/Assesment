package com.example.assesment.api

import com.example.assesment.model.User
import com.example.assesment.model.UserDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("users")
    suspend fun getUserData(
        @Query("page") page: Int
    ): UserDataModel
}