package com.example.devthink.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.devthink.databinding.FragmentCommunityTaskBinding

class TaskFragment : Fragment() {
    lateinit var binding: FragmentCommunityTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityTaskBinding.inflate(inflater, container, false)
        return binding.root
    }
}