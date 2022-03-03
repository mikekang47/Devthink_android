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
import com.example.devthink.databinding.FragmentSettingProfileCheckBinding

class SettingProfileCheckFragment: Fragment() {
    lateinit var binding: FragmentSettingProfileCheckBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingProfileCheckBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.settingCheckOkBtn.setOnClickListener {
            view.findNavController().navigate(R.id.action_settingProfileCheckFragment_to_SettingPersonalInfoFragment)
            onDestroy()
            onDestroyView()
        }
        binding.settingCheckExitIv.setOnClickListener {
            view.findNavController().navigate(R.id.action_settingProfileCheckFragment_to_SettingFragment)
            onDestroy()
            onDestroyView()
        }
    }
}