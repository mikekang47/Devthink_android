package com.example.devthink.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.devthink.R
import com.example.devthink.databinding.FragmentSignupInformationBinding

class SignUpInformationFragment : Fragment() {

    lateinit var binding: FragmentSignupInformationBinding
    private lateinit var navController: NavController

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

        binding.signupRightBtn.setOnClickListener {
            navController.navigate(R.id.action_signUpInformationFragment_to_signUpFinishFragment)
        }
        binding.signupLeftBtn.setOnClickListener {
            navController.navigate(R.id.action_signUpInformationFragment_to_signUpFragment)
        }
    }
}