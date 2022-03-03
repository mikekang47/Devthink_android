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

        //TODO: 현재 액티비티임 겹쳐지는 현상 수정해야함
        val mActivity = activity as CommunityActivity
        binding.fabButtonFree.setOnClickListener {
            mActivity.writeFree()
        }
        return binding.root
    }
}