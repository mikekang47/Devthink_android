package com.example.devthink.repository.network.api

import com.example.devthink.repository.dto.request.LoginRequest
import com.example.devthink.repository.dto.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("/session")
    suspend fun requestLogin(
        @Body request: LoginRequest
    ): LoginResponse
}