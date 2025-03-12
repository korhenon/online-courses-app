package com.example.onlinecourses.data.network

import com.example.onlinecourses.data.network.models.BlogDTO
import com.example.onlinecourses.data.network.models.CategoryDTO
import com.example.onlinecourses.data.network.models.CourseDTO
import com.example.onlinecourses.data.network.models.LectureDTO
import com.example.onlinecourses.data.network.models.ModuleDTO
import com.example.onlinecourses.data.network.models.ReviewDTO
import retrofit2.HttpException
import java.net.UnknownHostException
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    private val service: RetrofitInterface
) {
    suspend fun getCourses(): NetworkResponse<List<CourseDTO>> {
        return NetworkResponse(
            service.getCourses(),
            NetworkStatuses.Success
        )
    }

    suspend fun getCourseById(id: Int): NetworkResponse<CourseDTO> {
        return NetworkResponse(
            service.getCourseById("eq.$id")[0],
            NetworkStatuses.Success
        )
    }

    suspend fun getModulesForCourse(courseId: Int): NetworkResponse<List<ModuleDTO>> {
        return NetworkResponse(
            service.getModulesForCourse("eq.$courseId"),
            NetworkStatuses.Success
        )
    }

    suspend fun getLecturesForModule(moduleId: Int): NetworkResponse<List<LectureDTO>> {
        return NetworkResponse(
            service.getLecturesForModule("eq.$moduleId"),
            NetworkStatuses.Success
        )
    }

    suspend fun getReviewsForCourse(courseId: Int): NetworkResponse<List<ReviewDTO>> {
        return NetworkResponse(
            service.getReviews("eq.$courseId"),
            NetworkStatuses.Success
        )
    }

    suspend fun getCategories(): NetworkResponse<List<CategoryDTO>> {
        return NetworkResponse(
            service.getCategories(),
            NetworkStatuses.Success
        )
    }

    suspend fun getCoursesByCategory(categoryId: Int): NetworkResponse<List<CourseDTO>> {
        return NetworkResponse(
            service.getCoursesByCategory("eq.$categoryId"),
            NetworkStatuses.Success
        )
    }

    suspend fun getBlogs(): NetworkResponse<List<BlogDTO>> {
        return NetworkResponse(
            service.getBlogs(),
            NetworkStatuses.Success
        )
    }
}