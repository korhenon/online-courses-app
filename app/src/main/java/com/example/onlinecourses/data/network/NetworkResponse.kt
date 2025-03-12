package com.example.onlinecourses.data.network


data class NetworkResponse<Response>(
    val response: Response?,
    val status: NetworkStatuses
)
