package com.example.devthink.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.devthink.databinding.FragmentCommunityQuestionBinding
import com.example.devthink.databinding.FragmentCommunityReviewBinding

class ReviewFragment : Fragment() {
    lateinit var binding: FragmentCommunityReviewBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityReviewBinding.inflate(inflater, container, false)
        return binding.root
    }
}