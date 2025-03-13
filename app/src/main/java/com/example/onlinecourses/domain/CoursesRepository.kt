package com.example.onlinecourses.domain

import com.example.onlinecourses.data.models.Blog
import com.example.onlinecourses.data.models.Category
import com.example.onlinecourses.data.models.Course
import com.example.onlinecourses.data.models.Lecture
import com.example.onlinecourses.data.models.Module
import com.example.onlinecourses.data.models.Review
import com.example.onlinecourses.data.network.NetworkRepository
import com.example.onlinecourses.data.network.NetworkStatuses
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class CoursesRepository @Inject constructor(
    private val service: NetworkRepository
) {
    private suspend fun getModules(courseId: Int): List<Module>? {
        val response = service.getModulesForCourse(courseId)
        when (response.status) {
            NetworkStatuses.Success -> return response.response!!.map { module ->
                Module(
                    module.number,
                    module.name,
                    service.getLecturesForModule(module.id).response!!.map { lecture ->
                        Lecture(
                            lecture.name,
                            lecture.duration
                        )
                    }
                )
            }

            NetworkStatuses.HTTPError -> TODO()
            NetworkStatuses.NoInternet -> return null
        }
    }

    private suspend fun getReviews(courseId: Int): List<Review>? {
        val response = service.getReviewsForCourse(courseId)
        when (response.status) {
            NetworkStatuses.Success -> return response.response!!.map { review ->
                Review(
                    review.author,
                    LocalDate.parse(
                        review.created_at.split("+")[0],
                        DateTimeFormatter.ISO_LOCAL_DATE_TIME
                    ),
                    review.mark,
                    review.text
                )
            }

            NetworkStatuses.HTTPError -> TODO()
            NetworkStatuses.NoInternet -> return null
        }

    }

    suspend fun getCourses(): List<Course>? {
        val response = service.getCourses()
        when (response.status) {
            NetworkStatuses.Success -> return response.response!!.map {
                val modules = getModules(it.id)
                val reviews = getReviews(it.id)
                if (modules == null) return null
                if (reviews == null) return null
                Course(
                    it.id,
                    it.name,
                    it.learners,
                    it.image,
                    it.description,
                    it.level,
                    it.has_completion_certificate,
                    modules,
                    reviews
                )
            }

            NetworkStatuses.HTTPError -> TODO()
            NetworkStatuses.NoInternet -> return null
        }

    }

    suspend fun getCourseById(id: Int): Course? {
        val response = service.getCourseById(id)
        when (response.status) {
            NetworkStatuses.Success -> {
                val modules = getModules(response.response!!.id)
                val reviews = getReviews(response.response.id)
                if (modules == null) return null
                if (reviews == null) return null
                return Course(
                    response.response.id,
                    response.response.name,
                    response.response.learners,
                    response.response.image,
                    response.response.description,
                    response.response.level,
                    response.response.has_completion_certificate,
                    modules,
                    reviews
                )
            }

            NetworkStatuses.HTTPError -> TODO()
            NetworkStatuses.NoInternet -> return null
        }

    }

    suspend fun getCoursesByCategory(id: Int): List<Course>? {
        val response = service.getCoursesByCategory(id)
        when (response.status) {
            NetworkStatuses.Success -> {
                return response.response!!.map {
                    val modules = getModules(it.id)
                    val reviews = getReviews(it.id)
                    if (modules == null) return null
                    if (reviews == null) return null
                    Course(
                        it.id,
                        it.name,
                        it.learners,
                        it.image,
                        it.description,
                        it.level,
                        it.has_completion_certificate,
                        modules,
                        reviews
                    )
                }
            }

            NetworkStatuses.HTTPError -> TODO()
            NetworkStatuses.NoInternet -> return null
        }

    }

    suspend fun getCategories(): List<Category>? {
        val response = service.getCategories()
        when (response.status) {
            NetworkStatuses.Success -> {
                return response.response!!.map {
                    val courses = getCoursesByCategory(it.id)
                    if (courses == null) return null
                    Category(
                        it.id,
                        it.name,
                        courses.size,
                        it.icon,
                    )
                }
            }

            NetworkStatuses.HTTPError -> TODO()
            NetworkStatuses.NoInternet -> TODO()
        }

    }

    suspend fun getBlogs(): List<Blog>? {
        val response = service.getBlogs()
        when (response.status) {
            NetworkStatuses.Success -> return response.response!!.map {
                Blog(
                    it.author,
                    it.title,
                    it.text,
                    it.image,
                    LocalDate.parse(
                        it.created_at.split("+")[0],
                        DateTimeFormatter.ISO_LOCAL_DATE_TIME
                    ),
                    it.viewers,
                    it.tag
                )
            }

            NetworkStatuses.HTTPError -> TODO()
            NetworkStatuses.NoInternet -> return null
        }
    }
}