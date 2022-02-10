package com.example.devthink.repository.network.api

import retrofit2.Call
import com.example.devthink.entity.Book
import retrofit2.http.GET

interface ContentApi {

    @GET("/books/most")
    fun mostBook(
    ): Call<Book>
}