package com.example.onlinecourses.common

import com.example.onlinecourses.data.models.Course
import com.example.onlinecourses.data.models.InProgressCourse

fun InProgressCourse.progressPercent(): Int {
    return (progress.toFloat() / (course.duration().toFloat() / 100f)).toInt()
}

fun Course.duration(): Int {
    var sum = 0
    for (module in modules) {
        for (lecture in module.lectures) {
            sum += lecture.duration
        }
    }
    return sum
}

fun Course.mark(): Float {
    var sum = 0f
    for (review in reviews) {
        sum += review.mark.toFloat()
    }
    return sum / reviews.size.toFloat()
}