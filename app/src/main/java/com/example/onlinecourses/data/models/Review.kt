package com.example.onlinecourses.data.models

import java.time.LocalDate

data class Review(
    val author: String,
    val date: LocalDate,
    val mark: Int,
    val text: String
)
