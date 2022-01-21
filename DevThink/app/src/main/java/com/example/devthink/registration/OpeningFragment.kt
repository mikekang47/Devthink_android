package com.example.devthink.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.devthink.R
import com.example.devthink.databinding.FragmentOpeningBinding
import com.example.devthink.util.base.BaseFragment

class OpeningFragment : BaseFragment<FragmentOpeningBinding>(R.layout.fragment_opening) {
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //navController = Navigation.findNavController(view)

        /*binding.openingStartBtn.setOnClickListener {
            navController.navigate(R.id.action_openingFragment_to_questionFragment)
        }
        binding.openingSigninBtn.setOnClickListener {
            navController.navigate(R.id.action_openingFragment_to_signInFragment)
        }*/


        binding.openingSigninBtn.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_openingFragment_to_signInFragment)
            //navController.navigate(R.id.action_openingFragment_to_signInFragment)
        }
        binding.openingStartBtn.setOnClickListener {
            view.findNavController().navigate(R.id.action_openingFragment_to_questionFragment)
        }
    }
}