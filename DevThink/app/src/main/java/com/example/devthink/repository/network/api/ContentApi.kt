package com.example.devthink.repository.network.api

import com.example.devthink.entity.Book
import retrofit2.http.GET

interface ContentApi {

    @GET("/books/most")
    suspend fun mostBook(
    ): Book
}