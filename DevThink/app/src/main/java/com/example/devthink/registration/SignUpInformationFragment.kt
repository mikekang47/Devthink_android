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
import com.example.devthink.databinding.FragmentSignupInformationBinding
import com.example.devthink.repository.dto.request.SignupRequest
import com.example.devthink.repository.dto.response.SignupResponse
import com.example.devthink.repository.network.api.SignupApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SignUpInformationFragment : Fragment() {

    lateinit var binding: FragmentSignupInformationBinding
    private lateinit var navController: NavController

    private lateinit var userApi: SignupApi

    companion object {
        const val TAG = "TAG_DEVTHINK"
    }

    var signup: SignupResponse? = null

    var user = SignupRequest(
        blogAddr = "min.com",
        createAt = "2022-02-09T18:19:14.794Z",
        email = "hong@email.com",
        gitNickname = "hong",
        name = "hongminki",
        nickname = "hong0708",
        password = "1q2w3e4r",
        phoneNum = "010-1234-1234",
        point = 0,
        role = "senior",
        updateAt = "2022-02-09T18:19:14.794Z"
    )

    var check: Boolean? = null
    var emailResult: Boolean? = null
    var nicknameResult: Boolean? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        /*var user = SignupRequest(
            blogAddr = "min.com",
            createAt = "2022-2",
            email = "email",
            gitNickName = "hong",
            name = "hongminki",
            nickname = "hong0708",
            password = "1q2w3e4r",
            phoneNum = "010-0000-0000",
            point = 4,
            role = "android",
            updateAt = "2022-02"
        )*/

        val retrofit = Retrofit.Builder()
            .baseUrl("http://3.37.59.9:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        userApi = retrofit.create(
            SignupApi::class.java
        )

        binding.nicknameCheck.setOnClickListener {
            checkNickname("tester111", "test1234@email.com")
        }

        binding.signupRightBtn.setOnClickListener {
            navController.navigate(R.id.action_signUpInformationFragment_to_signUpFinishFragment)
            signUp()
        }
        binding.signupLeftBtn.setOnClickListener {
            navController.navigate(R.id.action_signUpInformationFragment_to_signUpFragment)
        }
    }

    // TODO: 체크의 경우 있으면 코드 400에 메세지 없어서 가능한 경우 코드 200에 false가 온다

    fun checkNickname(nickname: String, email: String): Boolean {
        userApi.checkNickname(nickname).enqueue(object : Callback<Boolean> {
            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }

            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                var nicknameCode = response.code()
                Log.d(TAG, "onResponse: nickname $nicknameCode")
                if (nicknameCode == 400) nicknameResult = false
                if (nicknameCode == 200) nicknameResult = true
            }
        })

        userApi.checkEmail(email).enqueue(object : Callback<Boolean> {
            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }

            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                var emailCode = response.code()
                Log.d(TAG, "onResponse: email $emailCode")
                if (emailCode == 400) emailResult = false
                if (emailCode == 200) emailResult = true
            }
        })
        return nicknameResult == true && emailResult == true
    }

    fun signUp(): Boolean {

        var answer = false

        userApi.requestSignup(user).enqueue(object : Callback<SignupResponse> {
            override fun onFailure(call: Call<SignupResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }

            override fun onResponse(
                call: Call<SignupResponse>,
                response: Response<SignupResponse>
            ) {
                var signUpCode = response.code()
                Log.d(TAG, "onResponse: $signUpCode")
                /*signup = response.body()
                Log.d(TAG, "onResponse: ${signup!!.email}")
                Log.d(TAG, "onResponse: ${signup!!.id}")*/
                answer = true
            }
        })
        return answer
    }
}