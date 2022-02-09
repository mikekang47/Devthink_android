package com.example.devthink.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.devthink.databinding.FragmentCommunityFreeBinding

class CommunityFreeFragment : Fragment() {
    lateinit var binding: FragmentCommunityFreeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityFreeBinding.inflate(inflater, container, false)
        return binding.root
    }
}