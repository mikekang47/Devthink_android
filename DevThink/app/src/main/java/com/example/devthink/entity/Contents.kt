package com.example.devthink.entity

data class Book(
    val id: Int,
    val imgUrl: String,
    val isbn: Int,
    val name: String,
    val reviewCnt: Int,
    val scoreAvg: Float,
    val writer: String
)