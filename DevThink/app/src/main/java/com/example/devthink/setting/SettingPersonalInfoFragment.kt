package com.example.devthink.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.devthink.R
import com.example.devthink.databinding.FragmentSettingPersonalInfoBinding

class SettingPersonalInfoFragment: Fragment() {
    lateinit var binding: FragmentSettingPersonalInfoBinding
    /*private lateinit var navController: NavController*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingPersonalInfoBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
 /*       navController = Navigation.findNavController(view)*/

        binding.settingPersonalExitIv.setOnClickListener {
            view.findNavController().navigate(R.id.action_settingPersonalInfoFragment_to_settingFragment)
        }
    }
}