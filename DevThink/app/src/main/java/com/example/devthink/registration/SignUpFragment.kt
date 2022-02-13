package com.example.devthink.registration

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.devthink.R
import com.example.devthink.databinding.FragmentSignupBinding
import com.example.devthink.registration.SignUpInformationFragment.Companion.TAG
import com.example.devthink.repository.network.api.SignupApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SignUpFragment : Fragment() {

    lateinit var binding: FragmentSignupBinding
    private lateinit var navController: NavController

    private lateinit var userApi: SignupApi
    var emailResult: Boolean? = null
    var check = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://3.37.59.9:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        userApi = retrofit.create(
            SignupApi::class.java
        )

        binding.signupRightBtn.setOnClickListener {
            //view.findNavController().navigate(R.id.action_signUpFragment_to_signUpInformationFragment)

            // TODO: 비동기식 처리 필요
            myPassword = binding.signupPwEt.text.toString()

            navController.navigate(R.id.action_signUpFragment_to_signUpInformationFragment)
            // TODO: 비동기식 처리 필요
            /*if(check){
                navController.navigate(R.id.action_signUpFragment_to_signUpInformationFragment)
            }*/
        }
        binding.signupLeftBtn.setOnClickListener {
            navController.navigate(R.id.action_signUpFragment_to_signupSelectFragment)
        }

        binding.signupEmailBtn.setOnClickListener {
            if(checkEmail(binding.signupEmailEt.text.toString())){
                check = true
                //binding.signupEmailBtn.setBackgroundColor()
            }
        }
    }

    // TODO: 체크의 경우 있으면 코드 400에 메세지 없어서 가능한 경우 코드 200에 false가 온다

    fun checkEmail(email: String): Boolean{
        userApi.checkEmail(email).enqueue(object : Callback<Boolean> {
            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }

            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                var emailCode = response.code()
                Log.d(TAG, "onResponse: email $emailCode")
                if (emailCode == 400) emailResult = false
                if (emailCode == 200){
                    emailResult = true
                    myEmail = email
                }
            }
        })
        return emailResult == true
    }

    companion object {
        var myEmail: String? = null
        var myPassword: String? = null
    }
}