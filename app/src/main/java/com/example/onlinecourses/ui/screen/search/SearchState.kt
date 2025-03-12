package com.example.onlinecourses.ui.screen.search

import com.example.onlinecourses.data.models.Course

data class SearchState(
    val query: String = "",
    val popularQueries: List<String> = listOf(),
    val courses: List<Course> = listOf(),
    val result: List<Course> = listOf(),
)
