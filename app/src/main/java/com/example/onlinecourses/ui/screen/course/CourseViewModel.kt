package com.example.onlinecourses.ui.screen.course

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.onlinecourses.common.BaseCourse
import com.example.onlinecourses.domain.CoursesRepository
import com.example.onlinecourses.ui.navigation.Destinations
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
                it.copy(
                    course = repository.getCourseById(savedStateHandle.toRoute<Destinations.Course>().id),
                    similar = repository.getCourses()
                )
            }
        }
    }

}