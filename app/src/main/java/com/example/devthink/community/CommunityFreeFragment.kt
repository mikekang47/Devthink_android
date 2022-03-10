package com.example.devthink.community

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devthink.MainActivity
import com.example.devthink.R
import com.example.devthink.databinding.FragmentCommunityFreeBinding

class CommunityFreeFragment : Fragment() {
    lateinit var binding: FragmentCommunityFreeBinding
    // private lateinit var navController: NavController

    private var contentDatas = ArrayList<Content>()

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

        // 일단 더미데이터로 넣어두었습니다!
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

        val contentRVAdapter = ContentRVAdapter(contentDatas)
        binding.freeContentRecyclerview.adapter = contentRVAdapter
        binding.freeContentRecyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 프로젝트지원 클릭시 CommunityProjectActivity로 이동
        binding.freeProjectTv.setOnClickListener {
            val intent = Intent(getActivity(), CommunityProjectActivity::class.java)
            startActivity(intent)
        }
    }
}