package com.example.devthink.community

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devthink.databinding.ActivityCommunityProjectBinding

class CommunityProjectActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommunityProjectBinding
    private var projectDatas = ArrayList<Project>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommunityProjectBinding.inflate(layoutInflater)

        setContentView(binding.root)

        inputDummyDatas()
    }

    private fun inputDummyDatas() {

        projectDatas.apply {
            add(Project("코알라 프로젝트", 8, "프론트, 백엔드", "22/01/17", "나무늘보다람쥐"))
            add(Project("다람쥐 프로젝트", 5, "프론트", "22/03/08", "김민희"))
            add(Project("DevThink", 7, "ios, 백엔드", "22/03/14", "안나"))
            add(Project("코알라 프로젝트", 8, "프론트, 백엔드", "22/01/17", "나무늘보다람쥐"))
            add(Project("다람쥐 프로젝트", 5, "프론트", "22/03/08", "김민희"))
            add(Project("DevThink", 7, "ios, 백엔드", "22/03/14", "안나"))
            add(Project("코알라 프로젝트", 8, "프론트, 백엔드", "22/01/17", "나무늘보다람쥐"))
            add(Project("다람쥐 프로젝트", 5, "프론트", "22/03/08", "김민희"))
            add(Project("DevThink", 7, "ios, 백엔드", "22/03/14", "안나"))
        }

        // Adapter 연결
        val projectRVAdapter = ProjectRVAdapter(projectDatas)
        binding.projectRecyclerview.adapter = projectRVAdapter
        binding.projectRecyclerview.layoutManager = GridLayoutManager(this, 2)
    }

}