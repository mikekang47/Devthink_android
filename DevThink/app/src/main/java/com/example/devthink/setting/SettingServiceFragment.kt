package com.example.devthink.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.devthink.R
import com.example.devthink.databinding.FragmentSettingPersonalInfoRoleBinding
import com.example.devthink.databinding.FragmentSettingServiceBinding

class SettingServiceFragment : Fragment() {
    lateinit var binding: FragmentSettingServiceBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingServiceBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.settingServiceBack.setOnClickListener {
            view.findNavController().navigate(R.id.action_settingServiceFragment_to_SettingFragment)
        }
        /*binding.settingCheckOkBtn.setOnClickListener {
            view.findNavController().navigate(R.id.action_settingProfileCheckFragment_to_SettingPersonalInfoFragment)
        }
        binding.settingCheckExitIv.setOnClickListener {
            view.findNavController().navigate(R.id.action_settingProfileCheckFragment_to_SettingFragment)
        }*/
    }
}