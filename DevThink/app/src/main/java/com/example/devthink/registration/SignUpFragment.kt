package com.example.devthink.registration

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.devthink.Data.*
import com.example.devthink.R
import com.example.devthink.databinding.FragmentSignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class SignUpFragment : Fragment(), SignUpView {

    lateinit var binding: FragmentSignUpBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        binding.signupRightBtn.setOnClickListener {
            //signUp()
            navController.navigate(R.id.action_signUpFragment_to_signUpInformationFragment)
        }
        binding.signupLeftBtn.setOnClickListener {
            navController.navigate(R.id.action_signUpFragment_to_signupSelectFragment)
        }
    }

    //    private fun getUser(): User {
//        val email: String = binding.signupEmailEt.text.toString() + "@" + binding.signupDirectInputEt.text.toString()
//        val pwd: String = binding.signupPwEt.text.toString()
//        val phone: String = binding.signupPhoneEt.text.toString()
//
//        return User(email, pwd, phone)
//    }
//
//
//    private fun signUp() {
//        if(binding.signupEmailEt.text.toString().isEmpty() || binding.signupDirectInputEt.text.toString().isEmpty()) {
//            Toast.makeText(getActivity(), "이메일 형식이 잘못되었습니다.", Toast.LENGTH_SHORT).show()
//            return
//        }
//
//        if(binding.signupPwEt.text.toString() != binding.signupPwCheckEt.text.toString()) {
//            Toast.makeText(getActivity(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
//            return
//        }
//
//        if(binding.signupPhoneEt.text.toString().isEmpty()) {
//            Toast.makeText(getActivity(), "휴대폰 번호 형식이 잘못되었습니다.", Toast.LENGTH_SHORT).show()
//            return
//        }
//
//        // // 핸드폰 인증번호 api 요청!
//
//        // baseUrl(ip주소)
//        // 현재는 없어서 umc에서 했던거 예시로 적어놨습니다. 작동은 안됩니다.
//
//        val authService = AuthService()
//        authService.setSignUpView(this)
//
//        //authService.signUp(getUser())
//
//        Log.d("SIGNUPACT/ASYN", "Hello, ")
//
//    }
//
//    private fun finish() {
//        navController.navigate(R.id.action_signUpFragment_to_signUpInformationFragment)
//    }
//
    override fun onSignUpLoading() {
        // 로딩되는 동안 호출
    }

    override fun onSignUpSuccess() {
        navController.navigate(R.id.action_signUpFragment_to_signUpInformationFragment)
    }

    override fun onSignUpFailure(code: Int, message: String) {
        when (code) {
            2016, 2017 -> {
                binding.signupEmailErrorTv.visibility = View.VISIBLE
                binding.signupEmailErrorTv.text = message
            }
        }
    }
}

