package com.example.onlinecourses.ui.screen.home

import com.example.onlinecourses.data.models.Blog
import com.example.onlinecourses.data.models.Category
import com.example.onlinecourses.data.models.Course
import com.example.onlinecourses.data.models.Offer
import com.example.onlinecourses.ui.utils.InternetState

data class HomeState(
    val internetState: InternetState = InternetState(),
    val name: String = "",
    val offers: List<Offer> = listOf(),
    val categories: List<Category> = listOf(),
    val courses: List<Course> = listOf(),
    val blogs: List<Blog> = listOf()
)