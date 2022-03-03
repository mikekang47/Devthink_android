package com.example.devthink.community

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.devthink.databinding.ActivityCommunityBinding
import com.example.devthink.databinding.ActivityWriteFreeBinding

class CommunityWriteFreeActivity : AppCompatActivity() {
    private val binding: ActivityWriteFreeBinding by lazy {
        ActivityWriteFreeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            setContentView(root)
            lifecycleOwner = this@CommunityWriteFreeActivity
        }
    }
}