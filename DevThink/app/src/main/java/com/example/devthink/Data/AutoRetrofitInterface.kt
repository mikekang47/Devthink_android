package com.example.devthink.Data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AutoRetrofitInterface {
    @POST("/users")
    fun signUp(@Body user: User): Call<AuthResponse>

    @POST("/users/login")
    fun login(@Body user: User): Call<AuthResponse>
}