package com.example.devthink.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.devthink.databinding.FragmentCommunityWriteReviewBinding

class CommunityWriteReviewFragment : Fragment() {
    lateinit var binding: FragmentCommunityWriteReviewBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityWriteReviewBinding.inflate(inflater, container, false)
        return binding.root
    }
}