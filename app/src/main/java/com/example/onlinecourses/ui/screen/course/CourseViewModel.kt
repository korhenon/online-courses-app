package com.example.onlinecourses.ui.screen.course

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import com.example.onlinecourses.common.BaseCourse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CourseViewModel @Inject constructor(): ViewModel() {
    private val _state = MutableStateFlow(CourseState(BaseCourse, listOf(BaseCourse, BaseCourse)))
    val state get() = _state.asStateFlow()


}