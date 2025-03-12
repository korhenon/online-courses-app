package com.example.onlinecourses.domain

import com.example.onlinecourses.data.models.Blog
import com.example.onlinecourses.data.models.Category
import com.example.onlinecourses.data.models.Course
import com.example.onlinecourses.data.models.Lecture
import com.example.onlinecourses.data.models.Module
import com.example.onlinecourses.data.models.Review
import com.example.onlinecourses.data.network.NetworkRepository
import com.example.onlinecourses.data.network.RetrofitInterface
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class CoursesRepository @Inject constructor(
    private val service: NetworkRepository
) {
    private suspend fun getModules(courseId: Int): List<Module> {
        return service.getModulesForCourse(courseId).response!!.map { module ->
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
    }

    private suspend fun getReviews(courseId: Int): List<Review> {
        return service.getReviewsForCourse(courseId).response!!.map { review ->
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
    }

    suspend fun getCourses(): List<Course> {
        return service.getCourses().response!!.map {
            Course(
                it.id,
                it.name,
                it.learners,
                it.image,
                it.description,
                it.level,
                it.has_completion_certificate,
                getModules(it.id),
                getReviews(it.id)
            )
        }
    }

    suspend fun getCourseById(id: Int): Course {
        val course = service.getCourseById(id).response!!
        return Course(
            course.id,
            course.name,
            course.learners,
            course.image,
            course.description,
            course.level,
            course.has_completion_certificate,
            getModules(course.id),
            getReviews(course.id)
        )
    }

    suspend fun getCoursesByCategory(id: Int): List<Course> {
        return service.getCoursesByCategory(id).response!!.map {
            Course(
                it.id,
                it.name,
                it.learners,
                it.image,
                it.description,
                it.level,
                it.has_completion_certificate,
                getModules(it.id),
                getReviews(it.id)
            )
        }
    }

    suspend fun getCategories(): List<Category> {
        return service.getCategories().response!!.map {
            Category(
                it.id,
                it.name,
                getCoursesByCategory(it.id).size,
                it.icon,
            )
        }
    }

    suspend fun getBlogs(): List<Blog> {
        return service.getBlogs().response!!.map {
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
    }
}