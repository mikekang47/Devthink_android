package com.example.devthink.community

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.devthink.databinding.ActivityCommunityBinding

class CommunityActivity: AppCompatActivity()  {
    lateinit var binding: ActivityCommunityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommunityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = TabAdapter(supportFragmentManager)
        adapter.addFragment(ReviewFragment(), "책리뷰")
        adapter.addFragment(FreeFragment(), "자유")
        adapter.addFragment(QuestionFragment(), "문의")
        adapter.addFragment(TaskFragment(), "직무")
        binding.viewpager.adapter = adapter
        binding.CommunityTablayout.setupWithViewPager(binding.viewpager)
    }
}