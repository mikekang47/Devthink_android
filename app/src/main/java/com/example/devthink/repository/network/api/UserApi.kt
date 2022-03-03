package com.example.devthink.repository.network.api

import com.example.devthink.repository.dto.request.LoginRequest
import com.example.devthink.repository.dto.request.SignupRequest
import com.example.devthink.repository.dto.response.LoginResponse
import com.example.devthink.repository.dto.response.SignupResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Call

interface UserApi {

    @POST("/session")
    suspend fun requestLogin(
        @Body request: LoginRequest
    ): LoginResponse

    /*@POST("/users")
    fun requestSignup(
        @Body request: SignupRequest
    ): Call<SignupResponse>*/
}