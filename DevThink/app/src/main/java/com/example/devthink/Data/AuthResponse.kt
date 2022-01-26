package com.example.devthink.Data

import androidx.work.ListenableWorker

data class AuthResponse(val isSuccess: Boolean, val code:Int, val message: String)