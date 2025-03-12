package com.example.onlinecourses.data.network.models

data class LectureDTO(
    val created_at: String,
    val duration: Int,
    val id: Int,
    val module: Int,
    val name: String
)