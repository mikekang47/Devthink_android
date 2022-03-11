package com.example.devthink.community

import android.annotation.SuppressLint
import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.devthink.databinding.FragmentCommunityProjectBinding

class CommunityProjectFragment : Fragment() {
    lateinit var binding: FragmentCommunityProjectBinding
    private var projectDatas = ArrayList<Project>()

    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityProjectBinding.inflate(inflater, container, false)

        projectDatas.apply {
            add(Project("코알라 프로젝트", 8, "프론트, 백엔드", "22/01/17까지", "나무늘보다람쥐"))
            add(Project("다람쥐 프로젝트", 5, "프론트", "22/03/08까지", "김민희"))
            add(Project("DevThink", 7, "ios, 백엔드", "22/03/14까지", "안나"))
            add(Project("코알라 프로젝트", 8, "프론트, 백엔드", "22/01/17까지", "나무늘보다람쥐"))
            add(Project("다람쥐 프로젝트", 5, "프론트", "22/03/08까지", "김민희"))
            add(Project("DevThink", 7, "ios, 백엔드", "22/03/14까지", "안나"))
            add(Project("코알라 프로젝트", 8, "프론트, 백엔드", "22/01/17까지", "나무늘보다람쥐"))
            add(Project("다람쥐 프로젝트", 5, "프론트", "22/03/08까지", "김민희"))
            add(Project("DevThink", 7, "ios, 백엔드", "22/03/14까지", "안나"))
        }

        val projectRVAdapter = ProjectRVAdapter(projectDatas)
        binding.projectRecyclerview.adapter = projectRVAdapter
        binding.projectRecyclerview.layoutManager = GridLayoutManager(context, 8, VERTICAL, false)

        return binding.root
    }
}