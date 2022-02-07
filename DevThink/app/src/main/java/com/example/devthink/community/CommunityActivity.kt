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
    }
}