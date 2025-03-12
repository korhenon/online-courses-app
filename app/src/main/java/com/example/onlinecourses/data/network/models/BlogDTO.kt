package com.example.onlinecourses.data.network.models

data class BlogDTO(
    val author: String,
    val created_at: String,
    val id: Int,
    val image: String,
    val tag: String,
    val text: String,
    val title: String,
    val viewers: Float
)