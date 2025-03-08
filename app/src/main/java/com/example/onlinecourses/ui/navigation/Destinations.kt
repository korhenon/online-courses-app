package com.example.onlinecourses.ui.navigation

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

sealed class Destinations {
    @Serializable
    object Home

    @Serializable
    data class Category(
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