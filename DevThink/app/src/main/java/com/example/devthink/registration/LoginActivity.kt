package com.example.devthink.registration

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.devthink.databinding.ActivityLoginBinding

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

//    private fun login() {
//        if(binding.loginEmailEt.text.toString().isEmpty()) {
//            Toast.makeText(this, "이메일을 입력하세요.", Toast.LENGTH_SHORT).show()
//            return
//        }
//
//        if(binding.loginPwEt.text.toString().isEmpty()) {
//            Toast.makeText(this, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show()
//            return
//        }
//
//        val email: String = binding.loginEmailEt.text.toString()
//        val pwd: String = binding.loginPwEt.text.toString()
//
//        val userDB = UserDatabase.getInstance(this)!!
//
//        val user = userDB.userDao().getUser(email, pwd)
//
//        user?.let {
//            // user가 null이 아닐 때 실행
//            Log.d("LOGINACT/GET_USER", "userId: ${user.id}, $user")
//            // 발급받은 jwt를 저장해주는 함수
//            saveJwt(user.id)
//        }
//
//        Toast.makeText(this, "회원정보가 존재하지 않습니다.", Toast.LENGTH_SHORT).show()
//    }
//
//    private fun saveJwt(jwt: Int){
//        val spf = getSharedPreferences("auth", MODE_PRIVATE)
//        val editor = spf.edit()
//
//        editor.putInt("jwt", jwt)
//        editor.apply()
//    }
}