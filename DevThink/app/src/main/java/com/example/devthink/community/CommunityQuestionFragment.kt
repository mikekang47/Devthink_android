package com.example.devthink.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devthink.databinding.FragmentCommunityQuestionBinding

class CommunityQuestionFragment : Fragment() {
    lateinit var binding: FragmentCommunityQuestionBinding
    private var contentDatas = ArrayList<Content>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityQuestionBinding.inflate(inflater, container, false)

        //TODO: 현재 액티비티임 겹쳐지는 현상 수정해야함
        val mActivity = activity as CommunityActivity
        binding.fabButtonQuestion.setOnClickListener {
            mActivity.writeFree()
        }

        contentDatas.apply {
            add(Content("가나다라마바", "03/05", "김민희", 1))
            add(Content("사아자차카타파하", "03/06", "안나", 13))
            add(Content("나무늘보다람쥐", "03/07", "김민희", 21))
            add(Content("갸갸갸갸갸갸갸갸갸", "03/08", "안나", 10))
            add(Content("가나다라마바", "03/05", "김민희", 1))
            add(Content("사아자차카타파하", "03/06", "안나", 13))
            add(Content("나무늘보다람쥐", "03/07", "김민희", 21))
            add(Content("갸갸갸갸갸갸갸갸갸", "03/08", "안나", 10))
        }

        val questionRVAdapter = QuestionRVAdapter(contentDatas)
        binding.queRecyclerview.adapter = questionRVAdapter
        binding.queRecyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        return binding.root
    }
}