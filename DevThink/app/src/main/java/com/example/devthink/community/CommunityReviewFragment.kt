package com.example.devthink.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.devthink.databinding.FragmentCommunityQuestionBinding
import com.example.devthink.databinding.FragmentCommunityReviewBinding

class CommunityReviewFragment : Fragment() {
    private val bookViewModel by viewModels<BookViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCommunityReviewBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            this.bookViewModel = this@CommunityReviewFragment.bookViewModel
            lifecycleOwner = this@CommunityReviewFragment
        }

        return binding.root
    }
}