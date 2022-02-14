package com.example.devthink.community

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.devthink.databinding.ActivityWriteFreeBinding
import com.example.devthink.databinding.ActivityWriteReviewBinding

class CommunityWriteReviewActivity : AppCompatActivity() {
    private val binding: ActivityWriteReviewBinding by lazy {
        ActivityWriteReviewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            setContentView(root)
            lifecycleOwner = this@CommunityWriteReviewActivity
        }
    }
}