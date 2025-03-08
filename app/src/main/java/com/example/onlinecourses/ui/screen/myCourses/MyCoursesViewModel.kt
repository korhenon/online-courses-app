package com.example.onlinecourses.ui.screen.myCourses

import androidx.compose.foundation.text.BasicText
import androidx.lifecycle.ViewModel
import com.example.onlinecourses.R
import com.example.onlinecourses.common.BaseCourse
import com.example.onlinecourses.data.models.Course
import com.example.onlinecourses.data.models.InProgressCourse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MyCoursesViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(
        MyCoursesState(
            listOf(
                InProgressCourse(
                    progress = 144,
                    course = BaseCourse
                ),
                InProgressCourse(
                    progress = 216,
                    course = BaseCourse
                )
            )
        )
    )
    val state get() = _state.asStateFlow()
}