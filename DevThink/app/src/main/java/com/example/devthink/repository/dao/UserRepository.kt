package com.example.devthink.repository.dao

import android.util.Log
import com.example.devthink.repository.dto.request.LoginRequest
import com.example.devthink.repository.network.RegistrationService
import com.example.devthink.util.Application

class UserRepository {

    suspend fun doLogin(email: String, password: String): Boolean =
        try {
            val loginResponse = RegistrationService.USER_API.requestLogin(
                LoginRequest(email, password)
            )
            Log.d("logintest",loginResponse.accessToken)
            Application.preferenceUtil.setString(TOKEN, loginResponse.accessToken)
            /*Application.preferenceUtil.setString(EMAIL, email)
            Application.preferenceUtil.setString(PASSWORD, password)*/
            true
        } catch (e: Exception) {
            false
        }


    companion object {
        private const val TOKEN = "token"
        private const val SIGNING_TOKEN = "signing token"
        private const val SIGNING_TOKEN_CODE = "code signing token"
        private const val EMAIL = "email"
        private const val PASSWORD = "password"
    }
}