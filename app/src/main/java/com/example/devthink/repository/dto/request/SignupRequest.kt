package com.example.devthink.repository.dto.request

data class SignupRequest(
    val blogAddr: String,
    val createAt: String,
    val email: String,
    val gitNickname: String,
    val name: String,
    val nickname: String,
    val password: String,
    val phoneNum: String,
    val point: Int,
    val role: String,
    val updateAt: String,
)