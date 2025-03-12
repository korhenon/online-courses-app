package com.example.onlinecourses.data.network.models

data class ReviewDTO(
    val author: String,
    val course: Int,
    val created_at: String,
    val id: Int,
    val mark: Int,
    val text: String
)