package com.example.onlinecourses.data.network

import android.util.Log
import com.example.onlinecourses.data.network.models.BlogDTO
import com.example.onlinecourses.data.network.models.CategoryDTO
import com.example.onlinecourses.data.network.models.CourseDTO
import com.example.onlinecourses.data.network.models.LectureDTO
import com.example.onlinecourses.data.network.models.ModuleDTO
import com.example.onlinecourses.data.network.models.ReviewDTO
import java.net.UnknownHostException
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    private val service: RetrofitInterface
) {
    suspend fun getCourses(): NetworkResponse<List<CourseDTO>> {
        return try {
            NetworkResponse(
                service.getCourses(),
                NetworkStatuses.Success
            )
        } catch (e: UnknownHostException) {
            Log.e("ERROR", e.toString())
            NetworkResponse(null, NetworkStatuses.NoInternet)
        }
    }

    suspend fun getCourseById(id: Int): NetworkResponse<CourseDTO> {
        return try {
            NetworkResponse(
                service.getCourseById("eq.$id")[0],
                NetworkStatuses.Success
            )
        } catch (e: UnknownHostException) {
            Log.e("ERROR", e.toString())
            NetworkResponse(null, NetworkStatuses.NoInternet)
        }
    }

    suspend fun getModulesForCourse(courseId: Int): NetworkResponse<List<ModuleDTO>> {
        return try {
            NetworkResponse(
                service.getModulesForCourse("eq.$courseId"),
                NetworkStatuses.Success
            )
        } catch (e: UnknownHostException) {
            Log.e("ERROR", e.toString())
            NetworkResponse(null, NetworkStatuses.NoInternet)
        }
    }

    suspend fun getLecturesForModule(moduleId: Int): NetworkResponse<List<LectureDTO>> {
        return try {
            NetworkResponse(
                service.getLecturesForModule("eq.$moduleId"),
                NetworkStatuses.Success
            )
        } catch (e: UnknownHostException) {
            Log.e("ERROR", e.toString())
            NetworkResponse(null, NetworkStatuses.NoInternet)
        }
    }

    suspend fun getReviewsForCourse(courseId: Int): NetworkResponse<List<ReviewDTO>> {
        return try {
            NetworkResponse(
                service.getReviews("eq.$courseId"),
                NetworkStatuses.Success
            )
        } catch (e: UnknownHostException) {
            Log.e("ERROR", e.toString())
            NetworkResponse(null, NetworkStatuses.NoInternet)
        }
    }

    suspend fun getCategories(): NetworkResponse<List<CategoryDTO>> {
        return try {
            NetworkResponse(
                service.getCategories(),
                NetworkStatuses.Success
            )
        } catch (e: UnknownHostException) {
            Log.e("ERROR", e.toString())
            NetworkResponse(null, NetworkStatuses.NoInternet)
        }
    }

    suspend fun getCoursesByCategory(categoryId: Int): NetworkResponse<List<CourseDTO>> {
        return try {
            NetworkResponse(
                service.getCoursesByCategory("eq.$categoryId"),
                NetworkStatuses.Success
            )
        } catch (e: UnknownHostException) {
            Log.e("ERROR", e.toString())
            NetworkResponse(null, NetworkStatuses.NoInternet)
        }
    }

    suspend fun getBlogs(): NetworkResponse<List<BlogDTO>> {
        return try {
            NetworkResponse(
                service.getBlogs(),
                NetworkStatuses.Success
            )
        } catch (e: UnknownHostException) {
            Log.e("ERROR", e.toString())
            NetworkResponse(null, NetworkStatuses.NoInternet)
        }
    }
}