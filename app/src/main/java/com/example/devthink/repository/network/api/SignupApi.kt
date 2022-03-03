package com.example.devthink.repository.network.api

import com.example.devthink.repository.dto.request.SignupRequest
import com.example.devthink.repository.dto.response.SignupResponse
import retrofit2.Call
import retrofit2.http.*

interface SignupApi {
    @POST("/users")
    fun requestSignup(
        @Body request: SignupRequest
    ): Call<SignupResponse>

    @GET("/users/nicknameCheck/{nickname}")
    fun checkNickname(
        @Path("nickname") nickName: String
    ): Call<Boolean>

    @GET("/users/emailCheck/{userEmail}")
    fun checkEmail(
        @Path("userEmail") userEmail: String
    ): Call<Boolean>
}