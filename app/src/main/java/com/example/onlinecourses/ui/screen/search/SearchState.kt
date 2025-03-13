package com.example.onlinecourses.ui.screen.search

import com.example.onlinecourses.data.models.Course
import com.example.onlinecourses.ui.utils.InternetState

data class SearchState(
    val internetState: InternetState = InternetState(),
    val query: String = "",
    val popularQueries: List<String> = listOf(),
    val courses: List<Course> = listOf(),
    val result: List<Course> = listOf(),
)
