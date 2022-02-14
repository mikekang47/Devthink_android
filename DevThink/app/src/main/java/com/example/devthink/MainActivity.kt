package com.example.devthink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.devthink.community.CommunityActivity
import com.example.devthink.databinding.ActivityMainBinding
import com.example.devthink.home.HomeFragment
import com.example.devthink.home.HomeNoteFragment
import com.example.devthink.home.HomeNoticeFragment
import com.example.devthink.home.HomeViewModel
import com.example.devthink.setting.SettingActivity
import com.example.devthink.setting.SettingFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val homeViewModel by viewModels<HomeViewModel>()
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            setContentView(root)
            homeViewModel = this@MainActivity.homeViewModel
            lifecycleOwner = this@MainActivity
        }
        setContentView(binding.root)

        binding.bnvMain.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.communityBtn -> {
                    /*supportFragmentManager.beginTransaction()
                        .replace(R.id.container, CommunityFragment()).commit()*/
                    val intent = Intent(this, CommunityActivity::class.java)
                    startActivity(intent)
                }
                R.id.settingBtn -> {
                    /*supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SettingFragment()).commit()*/

                    val intent = Intent(this, SettingActivity::class.java)
                    startActivity(intent)
                }
                R.id.homeBtn -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, HomeFragment()).commit()

                    /*val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)*/
                }
            }
            true
        }

        // 초기 화면
        binding.bnvMain.selectedItemId = R.id.homeBtn

        /*supportFragmentManager.beginTransaction()
            .replace(R.id.noticeNoteContainer, HomeNoteFragment()).commit()*/
        //binding.close.setOnClickListener { homeViewModel.closeRightPane() }

        initObserver()
    }

    override fun onBackPressed() {
        if (!homeViewModel.onBackPressed())
            finish()
    }


    private fun initObserver() {
        homeViewModel.isRightPaneOpen.observe(this) {
            if (it == true && slidingPaneLayout.isSlideable) {
                slidingPaneLayout.openPane()
            } else {
                slidingPaneLayout.closePane()
                Log.d("close",it.toString())
            }
        }

        homeViewModel.isNoteNotice.observe(this){
            if (it == true){
                supportFragmentManager.beginTransaction()
                    .replace(R.id.noticeNoteContainer, HomeNoteFragment()).commit()
            }else{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.noticeNoteContainer, HomeNoticeFragment()).commit()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        binding.bnvMain.selectedItemId = R.id.homeBtn
    }
}