package com.example.devthink

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.devthink.community.CommunityFragment
import com.example.devthink.databinding.ActivityMainBinding
import com.example.devthink.home.HomeFragment
import com.example.devthink.setting.SettingFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnvMain.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.communityBtn -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, CommunityFragment()).commit()
                }
                R.id.settingBtn -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SettingFragment()).commit()
                }
                R.id.homeBtn -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, HomeFragment()).commit()
                }
            }
            true
        }

        // 초기 화면
        binding.bnvMain.selectedItemId = R.id.homeBtn
    }
}