package com.example.devthink.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.devthink.databinding.FragmentCommunityTaskBinding

class CommunityTaskFragment : Fragment() {
    lateinit var binding: FragmentCommunityTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityTaskBinding.inflate(inflater, container, false)

        //TODO: 현재 액티비티임 겹쳐지는 현상 수정해야함
        val mActivity = activity as CommunityActivity
        binding.fabButtonTask.setOnClickListener {
            mActivity.writeFree()
        }

        return binding.root
    }
}