package com.example.onlinecourses.common

import com.example.onlinecourses.R
import com.example.onlinecourses.data.models.Blog
import com.example.onlinecourses.data.models.Course
import com.example.onlinecourses.data.models.Lecture
import com.example.onlinecourses.data.models.Module
import com.example.onlinecourses.data.models.Review
import java.time.LocalDate



val BaseCourse = Course(
    id = 1,
    name = "Data Science",
    learners = 10.5f,
    image = "",
    description = "The Macine learning basics program is designed to offer a soli foundation & work-ready skills for ML engineers. The Macine learning basics program is designed to offer a soli foundation & work-ready skills for ML engineers.",
    level = "Beginner",
    hasCompletionCertificate = true,
    modules = listOf(
        Module(
            number = 1,
            name = "Introduction",
            lectures = listOf(
                Lecture(name = "Sub lecture 1", duration = 30),
                Lecture(name = "Sub lecture 2", duration = 30),
                Lecture(name = "Sub lecture 3", duration = 30),
            )
        ),
        Module(
            number = 2,
            name = "Data Preprocessing",
            lectures = listOf(
                Lecture(name = "Sub lecture 1", duration = 30),
                Lecture(name = "Sub lecture 2", duration = 30),
                Lecture(name = "Sub lecture 3", duration = 30),
            )
        ),
        Module(
            number = 3,
            name = "Text Mining",
            lectures = listOf(
                Lecture(name = "Sub lecture 1", duration = 30),
                Lecture(name = "Sub lecture 2", duration = 30),
                Lecture(name = "Sub lecture 3", duration = 30),
            )
        ),
        Module(
            number = 4,
            name = "Practice Projects",
            lectures = listOf(
                Lecture(name = "Sub lecture 1", duration = 30),
                Lecture(name = "Sub lecture 2", duration = 30),
                Lecture(name = "Sub lecture 3", duration = 30),
            )
        ),
    ),
    reviews = listOf(
        Review(
            author = "Joseph Stanly",
            date = LocalDate.of(2021, 1, 1),
            mark = 4,
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Non number neque sit aliquam nam molestie dignissim ac eget. Fames congue faucibus in fermentum proin. A accumsan, convallis elementum amet sed. "
        ),
        Review(
            author = "Joseph Stanly",
            date = LocalDate.of(2021, 1, 1),
            mark = 4,
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Non number neque sit aliquam nam molestie dignissim ac eget. Fames congue faucibus in fermentum proin. A accumsan, convallis elementum amet sed. "
        ),
        Review(
            author = "Joseph Stanly",
            date = LocalDate.of(2021, 1, 1),
            mark = 5,
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Non number neque sit aliquam nam molestie dignissim ac eget. Fames congue faucibus in fermentum proin. A accumsan, convallis elementum amet sed. "
        ),
        Review(
            author = "Joseph Stanly",
            date = LocalDate.of(2021, 1, 1),
            mark = 5,
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Non number neque sit aliquam nam molestie dignissim ac eget. Fames congue faucibus in fermentum proin. A accumsan, convallis elementum amet sed. "
        ),
        Review(
            author = "Joseph Stanly",
            date = LocalDate.of(2021, 1, 1),
            mark = 5,
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Non number neque sit aliquam nam molestie dignissim ac eget. Fames congue faucibus in fermentum proin. A accumsan, convallis elementum amet sed. "
        ),
        Review(
            author = "Joseph Stanly",
            date = LocalDate.of(2021, 1, 1),
            mark = 4,
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Non number neque sit aliquam nam molestie dignissim ac eget. Fames congue faucibus in fermentum proin. A accumsan, convallis elementum amet sed. "
        ),
        Review(
            author = "Joseph Stanly",
            date = LocalDate.of(2021, 1, 1),
            mark = 4,
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Non number neque sit aliquam nam molestie dignissim ac eget. Fames congue faucibus in fermentum proin. A accumsan, convallis elementum amet sed. "
        ),
        Review(
            author = "Joseph Stanly",
            date = LocalDate.of(2021, 1, 1),
            mark = 5,
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Non number neque sit aliquam nam molestie dignissim ac eget. Fames congue faucibus in fermentum proin. A accumsan, convallis elementum amet sed. "
        ),
    )
)

val BaseBlog = Blog(
    author = "Rian Mendella",
    title = "How to improve Microsoft Excel Skills",
    text = "Most people know the power Excel can wield, especially when used properly. But fewer people know how to make the most of Excel...",
    image = "",
    date = LocalDate.of(2021, 1, 28),
    viewers = 20.5f,
    tag = "Data analysis"
)