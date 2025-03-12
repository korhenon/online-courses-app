package com.example.onlinecourses.data.models

data class Module(
    val number: Int,
    val name: String,
    val lectures: List<Lecture>
)
