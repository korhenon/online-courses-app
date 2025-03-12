package com.example.onlinecourses.data.models

import java.time.LocalDate

data class Blog(
    val author: String,
    val title: String,
    val text: String,
    val image: String,
    val date: LocalDate,
    val viewers: Float,
    val tag: String
)