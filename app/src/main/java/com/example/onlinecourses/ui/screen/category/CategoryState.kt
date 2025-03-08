package com.example.onlinecourses.ui.screen.category

import com.example.onlinecourses.data.models.Course

data class CategoryState(
    val category: String,
    val courses: List<Course> = listOf()
)
