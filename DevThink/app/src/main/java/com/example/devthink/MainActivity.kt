package com.example.devthink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.devthink.community.CommunityActivity
import com.example.devthink.community.CommunityFragment
import com.example.devthink.databinding.ActivityMainBinding
import com.example.devthink.home.HomeFragment
import com.example.devthink.home.HomeViewModel
import com.example.devthink.setting.SettingFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val homeViewModel by viewModels<HomeViewModel>()
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
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.container, SettingFragment()).commit()
                    val intent = Intent(this, SettingFragment::class.java)
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

        binding.close.setOnClickListener { homeViewModel.closeRightPane() }

        initObserver()
    }

    private fun initObserver() {
        homeViewModel.isRightPaneOpen.observe(this) {
            if (it == true && slidingPaneLayout.isSlideable) {
                slidingPaneLayout.openPane()
            } else {
                slidingPaneLayout.closePane()
            }
        }
    }
}