package com.example.devthink.repository.dto.response

data class SignupResponse(
    val blogAddr: String,
    val createAt: String,
    val email: String,
    val gitNickName: String,
    val id: Int,
    val name: String,
    val nickname: String,
    val phoneNum: String,
    val point: Int,
    val role: String,
    val updateAt: String,
)