package com.example.onlinecourses.ui.screen.myCourses

import com.example.onlinecourses.data.models.InProgressCourse

data class MyCoursesState(
    val courses: List<InProgressCourse> = listOf()
)
