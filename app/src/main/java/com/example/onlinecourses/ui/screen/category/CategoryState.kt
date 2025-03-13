package com.example.onlinecourses.ui.screen.category

import com.example.onlinecourses.data.models.Course
import com.example.onlinecourses.ui.utils.InternetState

data class CategoryState(
    val internetState: InternetState = InternetState(),
    val category: String,
    val courses: List<Course> = listOf()
)
