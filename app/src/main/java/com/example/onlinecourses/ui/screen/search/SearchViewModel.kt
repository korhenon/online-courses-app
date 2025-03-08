package com.example.onlinecourses.ui.screen.search

import androidx.lifecycle.ViewModel
import com.example.onlinecourses.common.BaseCourse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(
        SearchState(
            popularQueries = listOf("Cyber Security", "Data Science", "Java", "React Js"),
            courses = listOf(BaseCourse, BaseCourse, BaseCourse)
        )
    )
    val state get() = _state.asStateFlow()

    fun updateQuery(value: String) {
        _state.update {
            it.copy(query = value)
        }
    }
}