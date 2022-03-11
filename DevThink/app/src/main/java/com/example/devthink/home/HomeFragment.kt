package com.example.devthink.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.devthink.R
import com.example.devthink.community.CommunityReviewFragment
import com.example.devthink.databinding.FragmentHomeBinding
import com.example.devthink.entity.Book
import com.example.devthink.repository.network.api.ContentApi
import kotlinx.android.synthetic.main.fragment_community_review.*
import kotlinx.android.synthetic.main.fragment_community_review.home_best_book_author_tv
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {
    private val homeViewModel by activityViewModels<HomeViewModel>()

    companion object {
        const val TAG = "TAG_DEVTHINK"
    }

    var book: Book? = null

    private lateinit var contentApi: ContentApi

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            this.homeViewModel = this@HomeFragment.homeViewModel
            lifecycleOwner = this@HomeFragment
        }
        /*binding.apply {
            noteBtn.setOnClickListener { homeViewModel.openRightPane() }
            noticeBtn.setOnClickListener { homeViewModel!!.openRightPane() }
        }*/
        binding.homeNoteBtn.setOnClickListener {
            homeViewModel.openRightPane()
            homeViewModel.openNote()
        }

        binding.homeNoticeBtn.setOnClickListener {
            homeViewModel.openRightPane()
            homeViewModel.openNotice()
        }

        val retrofit = Retrofit.Builder()
            .baseUrl("http://3.37.59.9:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        contentApi = retrofit.create(
            ContentApi::class.java
        )
        loadMostBook()

        return binding.root
    }

    fun loadMostBook() {
        contentApi.mostBook().enqueue(object : Callback<Book> {
            override fun onFailure(call: Call<Book>, t: Throwable) {
                Log.d(CommunityReviewFragment.TAG, "onFailure: ${t.message}")
            }

            // TODO: 베스트 리뷰 책 로그에 잘 나옴 레이아웃이랑 연결 필요

            override fun onResponse(call: Call<Book>, response: Response<Book>) {
                book = response.body()
                Log.d(CommunityReviewFragment.TAG, "onResponse Code: ${book!!.id}")
                Log.d(CommunityReviewFragment.TAG, "onResponse Token: ${book!!.imgUrl}")
                Log.d(CommunityReviewFragment.TAG, "onResponse Token: ${book!!.isbn}")
                Log.d(CommunityReviewFragment.TAG, "onResponse Token: ${book!!.reviewCnt}")
                Log.d(CommunityReviewFragment.TAG, "onResponse Token: ${book!!.scoreAvg}")
                Log.d(CommunityReviewFragment.TAG, "onResponse Token: ${book!!.writer}")

                home_best_book_title_tv.setText(book!!.name)
                home_best_book_author_tv.setText(book!!.writer)

            }
        })
    }
}
