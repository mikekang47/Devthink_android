package com.example.devthink.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.devthink.R
import com.example.devthink.databinding.FragmentSettingPersonalInfoRoleBinding

class SettingPersonalInfoRoleFragment : Fragment() {
    lateinit var binding: FragmentSettingPersonalInfoRoleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingPersonalInfoRoleBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.personalInfoBtn.setOnClickListener {
            view.findNavController().navigate(R.id.action_settingPersonalInfoRoleFragment_to_SettingFragment)
        }
        /*binding.settingCheckOkBtn.setOnClickListener {
            view.findNavController().navigate(R.id.action_settingProfileCheckFragment_to_SettingPersonalInfoFragment)
        }
        binding.settingCheckExitIv.setOnClickListener {
            view.findNavController().navigate(R.id.action_settingProfileCheckFragment_to_SettingFragment)
        }*/
    }

}