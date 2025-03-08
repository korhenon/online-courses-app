package com.example.onlinecourses.data.models

data class Course(
    val name: String,
    val learners: Float,
    val image: Int,
    val description: String,
    val level: String,
    val hasCompletionCertificate: Boolean,
    val modules: List<Module>,
    val reviews: List<Review>
)