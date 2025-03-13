package com.example.onlinecourses.ui.screen.course

import com.example.onlinecourses.data.models.Course
import com.example.onlinecourses.ui.utils.InternetState

data class CourseState(
    val internetState: InternetState = InternetState(),
    val course: Course? = null,
    val similar: List<Course> = listOf()
)
