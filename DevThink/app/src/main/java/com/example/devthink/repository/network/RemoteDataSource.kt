package com.example.devthink.repository.network

import com.example.devthink.repository.network.api.UserApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "http://3.37.59.9:8080"
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object RegistrationService {
    val USER_API: UserApi by lazy {
        retrofit.create(UserApi::class.java)
    }
}


