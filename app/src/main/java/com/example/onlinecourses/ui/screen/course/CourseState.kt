package com.example.onlinecourses.ui.screen.course

import com.example.onlinecourses.data.models.Course

data class CourseState(
    val course: Course? = null,
    val similar: List<Course> = listOf()
)
