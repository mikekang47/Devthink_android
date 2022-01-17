package com.example.devthink.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.devthink.R
import com.example.devthink.databinding.FragmentSignupSelectBinding

class SignUpSelectFragment: Fragment() {

    lateinit var binding: FragmentSignupSelectBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupSelectBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        binding.signupEmailBtn.setOnClickListener {
            navController.navigate(R.id.action_signupSelectFragment_to_signUpFragment)
        }
        binding.signupMainKakaoBtn.setOnClickListener {
            // TODO: 카카오톡을 통한 로그인 기능 구현 + 심플앱은 구현했으나 앱키값 깃문제로 보류
        }
    }
}