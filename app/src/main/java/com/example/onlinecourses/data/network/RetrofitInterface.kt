package com.example.onlinecourses.data.network

import com.example.onlinecourses.data.models.Review
import com.example.onlinecourses.data.network.models.BlogDTO
import com.example.onlinecourses.data.network.models.CategoryDTO
import com.example.onlinecourses.data.network.models.CourseDTO
import com.example.onlinecourses.data.network.models.LectureDTO
import com.example.onlinecourses.data.network.models.ModuleDTO
import com.example.onlinecourses.data.network.models.ReviewDTO
import com.example.onlinecourses.ui.navigation.Destinations
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetrofitInterface {
    companion object {
        const val API_KEY_HEADER =
            "apikey:eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InRlYm50dWVhaGJid3hjaXpxbmZpIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDEwMTU4MDgsImV4cCI6MjA1NjU5MTgwOH0.XVSMaub6Gt59jWorf-COjo73EbZdq9khDXw6TgvOmyo"
        const val AUTHORIZATION_HEADER =
            "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InRlYm50dWVhaGJid3hjaXpxbmZpIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDEwMTU4MDgsImV4cCI6MjA1NjU5MTgwOH0.XVSMaub6Gt59jWorf-COjo73EbZdq9khDXw6TgvOmyo"
    }

    @GET("courses")
    @Headers(API_KEY_HEADER, AUTHORIZATION_HEADER)
    suspend fun getCourses(@Query("select") select: String = "*"): List<CourseDTO>

    @GET("courses")
    @Headers(API_KEY_HEADER, AUTHORIZATION_HEADER)
    suspend fun getCourseById(
        @Query("id") idFilter: String,
        @Query("select") select: String = "*"
    ): List<CourseDTO>

    @GET("courses")
    @Headers(API_KEY_HEADER, AUTHORIZATION_HEADER)
    suspend fun getCoursesByCategory(
        @Query("category") categoryFilter: String,
        @Query("select") select: String = "*"
    ): List<CourseDTO>

    @GET("modules")
    @Headers(API_KEY_HEADER, AUTHORIZATION_HEADER)
    suspend fun getModulesForCourse(
        @Query("course") courseFilter: String,
        @Query("select") select: String = "*"
    ): List<ModuleDTO>

    @GET("lectures")
    @Headers(API_KEY_HEADER, AUTHORIZATION_HEADER)
    suspend fun getLecturesForModule(
        @Query("module") moduleFilter: String,
        @Query("select") select: String = "*"
    ): List<LectureDTO>

    @GET("reviews")
    @Headers(API_KEY_HEADER, AUTHORIZATION_HEADER)
    suspend fun getReviews(
        @Query("course") courseFilter: String,
        @Query("select") select: String = "*"
    ): List<ReviewDTO>


    @GET("categories")
    @Headers(API_KEY_HEADER, AUTHORIZATION_HEADER)
    suspend fun getCategories(
        @Query("select") select: String = "*"
    ): List<CategoryDTO>

    @GET("blogs")
    @Headers(API_KEY_HEADER, AUTHORIZATION_HEADER)
    suspend fun getBlogs(
        @Query("select") select: String = "*"
    ): List<BlogDTO>
}