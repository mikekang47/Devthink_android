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
import com.example.devthink.databinding.FragmentSettingNoticeBinding

class SettingNoticeFragment : Fragment() {
    lateinit var binding: FragmentSettingNoticeBinding
    /*private lateinit var navController: NavController*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingNoticeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
/*        navController = Navigation.findNavController(view)*/

        binding.settingNoticeExitIv.setOnClickListener {
            view.findNavController().navigate(R.id.action_settingNoticeFragment_to_SettingFragment)
            onDestroy()
            onDestroyView()
        }
    }

}