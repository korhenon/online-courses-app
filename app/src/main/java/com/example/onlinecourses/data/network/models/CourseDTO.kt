package com.example.onlinecourses.data.network.models

data class CourseDTO(
    val created_at: String,
    val description: String,
    val has_completion_certificate: Boolean,
    val id: Int,
    val image: String,
    val learners: Float,
    val level: String,
    val name: String
)