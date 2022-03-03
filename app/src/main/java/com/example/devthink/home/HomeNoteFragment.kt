package com.example.devthink.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.devthink.databinding.FragmentHomeNoteBinding

class HomeNoteFragment : Fragment() {
    private val homeViewModel by activityViewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeNoteBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            this.homeViewModel = this@HomeNoteFragment.homeViewModel
            lifecycleOwner = this@HomeNoteFragment
        }
        binding.backToHomeNote.setOnClickListener {
            // TODO: 뒤로 가기 제대로 작동 안함 이유 찾아야함
            homeViewModel.closeRightPane()
        }

        /*binding.apply {
            noteBtn.setOnClickListener { homeViewModel.openRightPane() }
            noticeBtn.setOnClickListener { homeViewModel!!.openRightPane() }
        }*/
        /*binding.homeNoteBtn.setOnClickListener { homeViewModel.openRightPane() }*/

        return binding.root
    }
}