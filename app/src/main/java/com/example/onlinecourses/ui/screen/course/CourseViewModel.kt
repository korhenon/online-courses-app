package com.example.onlinecourses.ui.screen.course

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.onlinecourses.common.BaseCourse
import com.example.onlinecourses.domain.CoursesRepository
import com.example.onlinecourses.ui.navigation.Destinations
import com.example.onlinecourses.ui.utils.InternetState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CourseViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: CoursesRepository
) : ViewModel() {
    private val _state = MutableStateFlow(CourseState())
    val state get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(internetState = InternetState(isLoading = true))
            }
            val course =
                repository.getCourseById(savedStateHandle.toRoute<Destinations.Course>().id)
            val similar = repository.getCourses()
            _state.update {
                if (course == null || similar == null) {
                    it.copy(
                        internetState = InternetState(isLoading = false, isNoInternet = true)
                    )
                } else {
                    it.copy(
                        course = course,
                        similar = similar,
                        internetState = InternetState(isLoading = false)
                    )
                }

            }
        }
    }

}