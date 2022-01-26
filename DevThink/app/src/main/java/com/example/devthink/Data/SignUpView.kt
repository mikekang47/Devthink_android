package com.example.devthink.Data

interface SignUpView {
    // activity, service class를 연결시켜놓은 interface
    fun onSignUpLoading()
    fun onSignUpSuccess()
    fun onSignUpFailure(code: Int, message: String)
}