package com.example.onlinecourses.ui.navigation

import kotlinx.serialization.Serializable

sealed class Destinations {
    @Serializable
    object Home

    @Serializable
    data class Category(
        val id: Int,
        val category: String
    )

    @Serializable
    object Search

    @Serializable
    object MyCourses

    @Serializable
    data class Course(
        val id: Int
    )

    @Serializable
    object Blogs

    @Serializable
    object Profile
}