package com.example.devthink.registration

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.devthink.MainActivity
import com.example.devthink.R
import com.example.devthink.databinding.ActivitySigninBinding
import com.example.devthink.util.Status
import com.example.devthink.util.observeIfNotHandled

class SignInActivity : AppCompatActivity() {
    private val binding: ActivitySigninBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_signin)
    }
    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.loginViewModel = viewModel

        viewModel.loginStatus.observeIfNotHandled(this) {
            if (it == Status.SUCCESS) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                // TODO: 로그인 관련 종료해야함
                //finish()
            }
        }
    }

}