package com.example.onlinecourses.data.models

data class Module(
    val id: Int,
    val name: String,
    val lectures: List<Lecture>
)
