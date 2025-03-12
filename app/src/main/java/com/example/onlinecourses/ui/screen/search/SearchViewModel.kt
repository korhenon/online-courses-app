package com.example.onlinecourses.ui.screen.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinecourses.common.BaseCourse
import com.example.onlinecourses.data.models.Course
import com.example.onlinecourses.domain.CoursesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: CoursesRepository
) : ViewModel() {
    private val _state = MutableStateFlow(
        SearchState(
            popularQueries = listOf("Cyber Security", "Data Science", "Java", "React Js"),
        )
    )
    val state get() = _state.asStateFlow()

    fun updateQuery(value: String) {
        _state.update {
            it.copy(query = value, result = it.courses.filter { course -> value in course.name })
        }
    }

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(courses = repository.getCourses())
            }
        }
    }
}