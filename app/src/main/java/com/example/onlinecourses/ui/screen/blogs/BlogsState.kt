package com.example.onlinecourses.ui.screen.blogs

import com.example.onlinecourses.data.models.Blog
import com.example.onlinecourses.ui.utils.InternetState

data class BlogsState(
    val internetState: InternetState = InternetState(),
    val blogs: List<Blog> = listOf()
)
