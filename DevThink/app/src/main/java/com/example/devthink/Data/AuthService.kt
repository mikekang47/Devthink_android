package com.example.devthink.Data

import android.util.Log
import android.view.View
import com.example.devthink.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthService {
    private lateinit var signUpView: SignUpView
    private lateinit var loginView: LoginView

    fun setSignUpView(signUpView: SignUpView) {
        this.signUpView = signUpView
    }

    fun setLoginView(loginView: LoginView) {
        this.loginView = loginView
    }

    fun signUp(user: User) {
        val authService = getRetrofit().create(AutoRetrofitInterface::class.java)

        signUpView.onSignUpLoading()

        // api 호출
        authService.signUp(user).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                // 응답이 왔을 때
                Log.d("SIGNUPACT/API-RESPONSE", response.toString())

                val resp = response.body()!!

                when (resp.code) {
                    1000 -> signUpView.onSignUpSuccess()
                    else -> signUpView.onSignUpFailure(resp.code, resp.message)
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                // 네트워크가 실패했을 때
                Log.d("SIGNUPACT/API-ERROR", t.message.toString())
                signUpView.onSignUpFailure(400, "네트워크 오류가 발생했습니다.")
            }

        })
        Log.d("SIGNUPACT/ASYN", "Hello, ")
    }
}