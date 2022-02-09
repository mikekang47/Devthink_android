package com.example.devthink.registration

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devthink.R
import com.example.devthink.repository.dao.UserRepository
import com.example.devthink.util.Event
import com.example.devthink.util.Status
import com.example.devthink.util.isValid
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val userRepository: UserRepository by lazy {
        UserRepository()
    }

    val loginStatus = MutableLiveData<Event<Status>>()
    val email = MutableLiveData("")
    val password = MutableLiveData("")
    val loginMessage = MutableLiveData<Int>(R.string.empty_text)

    private fun login() {
        viewModelScope.launch {
            if (userRepository.doLogin(email.value.toString(), password.value.toString())) {
                loginStatus.postValue(Event(Status.SUCCESS))
                Log.d("logintest","login ok")
            } else {
                loginMessage.postValue(R.string.notice_check_email_password)
                loginStatus.postValue(Event(Status.FAILURE))
            }
        }
    }

    fun checkLogin() {
        val emailValue = email.value ?: ""
        val passwordValue = password.value ?: ""

        Log.d("logintest",emailValue)
        Log.d("logintest",passwordValue)

        if (emailValue == "" || passwordValue == "") {
            loginMessage.postValue(R.string.notice_input_email_password)
        } /*else if (!emailValue.isValid(EMAILREGEX)) {
            loginMessage.postValue(R.string.notice_error_email)
        }*/ else {
            login()
        }
    }

    companion object {
        private const val EMAILREGEX = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,8}$"
    }
}