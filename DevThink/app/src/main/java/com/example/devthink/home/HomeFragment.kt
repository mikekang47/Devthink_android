package com.example.devthink.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.devthink.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private val homeViewModel by activityViewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            this.homeViewModel = this@HomeFragment.homeViewModel
            lifecycleOwner = this@HomeFragment
        }
        /*binding.apply {
            noteBtn.setOnClickListener { homeViewModel.openRightPane() }
            noticeBtn.setOnClickListener { homeViewModel!!.openRightPane() }
        }*/
        binding.homeNoteBtn.setOnClickListener { homeViewModel.openRightPane() }
        return binding.root
    }
}
/*? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            noteBtn.setOnClickListener { homeViewModel.openRightPane() }
            noticeBtn.setOnClickListener { homeViewModel.openRightPane() }
        }
    }
}*/