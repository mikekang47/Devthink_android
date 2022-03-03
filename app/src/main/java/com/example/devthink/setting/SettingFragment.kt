package com.example.devthink.setting

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.example.devthink.R
import com.example.devthink.databinding.FragmentSettingBinding
import com.example.devthink.util.base.BaseFragment

class SettingFragment : BaseFragment<FragmentSettingBinding>(R.layout.fragment_setting) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.settingModifyTv.setOnClickListener {
            view.findNavController().navigate(R.id.action_settingFragment_to_settingProfileCheckFragment)
        }
        binding.settingAnnouncementTv.setOnClickListener {
            view.findNavController().navigate(R.id.action_settingFragment_to_settingNoticeFragment)
        }

        binding.settingServiceTv.setOnClickListener {
            view.findNavController().navigate(R.id.action_settingFragment_to_settingServiceFragment)
        }
        binding.settingPersonalTv.setOnClickListener {
            view.findNavController().navigate(R.id.action_settingFragment_to_settingPersonalInfoRoleFragment)
        }
    }
}