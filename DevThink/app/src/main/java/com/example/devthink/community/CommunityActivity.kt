package com.example.devthink.community

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.devthink.MainActivity
import com.example.devthink.R
import com.example.devthink.databinding.ActivityCommunityBinding
import com.example.devthink.setting.SettingActivity

class CommunityActivity: AppCompatActivity()  {
    private val binding: ActivityCommunityBinding by lazy {
        ActivityCommunityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            setContentView(root)
            lifecycleOwner = this@CommunityActivity
        }

        val adapter = TabAdapter(supportFragmentManager)
        adapter.addFragment(CommunityReviewFragment(), "책리뷰")
        adapter.addFragment(CommunityFreeFragment(), "자유")
        adapter.addFragment(CommunityQuestionFragment(), "문의")
        adapter.addFragment(CommunityTaskFragment(), "직무")
        binding.viewpager.adapter = adapter
        binding.CommunityTablayout.setupWithViewPager(binding.viewpager)

        binding.bnvMain.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.communityBtn -> {

                }
                R.id.settingBtn -> {
                    val intent = Intent(this, SettingActivity::class.java)
                    startActivity(intent)
                }
                R.id.homeBtn -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
            true
        }
        binding.bnvMain.selectedItemId = R.id.communityBtn
    }

    fun writeReview(){
        /*supportFragmentManager.beginTransaction()
            .replace(R.id.containerCommunity, CommunityWriteReviewFragment()).commit()*/
        val intent = Intent(this, CommunityWriteReviewActivity::class.java)
        startActivity(intent)
    }

    fun writeFree(){
        /*supportFragmentManager.beginTransaction()
            .replace(R.id.containerCommunity, CommunityWriteReviewFragment()).commit()*/
        val intent = Intent(this, CommunityWriteFreeActivity::class.java)
        startActivity(intent)
    }
}