package com.example.devthink.registration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.devthink.R
import com.example.devthink.databinding.ActivityLoginBinding
import com.example.devthink.home.HomeFragment

class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
        /*DataBindingUtil.setContentView(this,R.layout.activity_login)*/
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            setContentView(root)
            lifecycleOwner = this@LoginActivity
        }
    }
}