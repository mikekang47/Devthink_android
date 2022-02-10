package com.example.devthink.community

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.example.devthink.R
import com.example.devthink.databinding.ActivityCommunityBinding
import com.example.devthink.home.HomeFragment
import com.example.devthink.setting.SettingFragment

class CommunityActivity: AppCompatActivity()  {
    private val binding: ActivityCommunityBinding by lazy {
        ActivityCommunityBinding.inflate(layoutInflater)
    }
    /*private val bookViewModel by viewModels<BookViewModel>()*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            setContentView(root)
            /*bookViewModel = this@CommunityActivity.bookViewModel*/
            lifecycleOwner = this@CommunityActivity
        }

        val adapter = TabAdapter(supportFragmentManager)
        adapter.addFragment(CommunityReviewFragment(), "책리뷰")
        adapter.addFragment(CommunityFreeFragment(), "자유")
        adapter.addFragment(CommunityQuestionFragment(), "문의")
        adapter.addFragment(CommunityTaskFragment(), "직무")
        binding.viewpager.adapter = adapter
        binding.CommunityTablayout.setupWithViewPager(binding.viewpager)

        /*binding.bnvCommunity.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.reviewBtn -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container11, CommunityReviewFragment()).commit()
                }
                R.id.freeBtn -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container11, CommunityFreeFragment()).commit()
                }
                R.id.questionBtn -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container11, CommunityQuestionFragment()).commit()
                }
                R.id.taskBtn -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container11, CommunityTaskFragment()).commit()
                }
            }
            true
        }

        // 초기 화면
        binding.bnvCommunity.selectedItemId = R.id.reviewBtn*/
    }
}