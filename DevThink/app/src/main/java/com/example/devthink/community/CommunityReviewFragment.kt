package com.example.devthink.community

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.devthink.R
import com.example.devthink.databinding.FragmentCommunityQuestionBinding
import com.example.devthink.databinding.FragmentCommunityReviewBinding
import com.example.devthink.entity.Book
import com.example.devthink.home.HomeFragment
import com.example.devthink.repository.network.api.ContentApi
import kotlinx.android.synthetic.main.fragment_community_review.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CommunityReviewFragment : Fragment() {
    /*private val bookViewModel by viewModels<BookViewModel>()*/
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
        val binding = FragmentCommunityReviewBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            /*this.bookViewModel = this@CommunityReviewFragment.bookViewModel*/
            lifecycleOwner = this@CommunityReviewFragment
        }

        val retrofit = Retrofit.Builder()
            .baseUrl("http://3.37.59.9:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        contentApi = retrofit.create(
            ContentApi::class.java
        )
        loadMostBook()

        //TODO: 현재 액티비티임 겹쳐지는 현상 수정해야함
        val mActivity = activity as CommunityActivity
        binding.fabButtonReview.setOnClickListener {
            mActivity.writeReview()
        }

        return binding.root
    }

    fun loadMostBook() {
        contentApi.mostBook().enqueue(object : Callback<Book> {
            override fun onFailure(call: Call<Book>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }

            // TODO: 베스트 리뷰 책 로그에 잘 나옴 레이아웃이랑 연결 필요

            override fun onResponse(call: Call<Book>, response: Response<Book>) {
                book = response.body()
                Log.d(TAG, "onResponse Code: ${book!!.id}")
                Log.d(TAG, "onResponse Token: ${book!!.imgUrl}")
                Log.d(TAG, "onResponse Token: ${book!!.isbn}")
                Log.d(TAG, "onResponse Token: ${book!!.reviewCnt}")
                Log.d(TAG, "onResponse Token: ${book!!.scoreAvg}")
                Log.d(TAG, "onResponse Token: ${book!!.writer}")

                home_best_book_author_tv.setText(book!!.writer)
                home_best_book_title_01_tv.setText(book!!.name)

            }
        })
    }
}