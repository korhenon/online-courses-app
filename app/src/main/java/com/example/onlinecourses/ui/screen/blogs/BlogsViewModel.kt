package com.example.onlinecourses.ui.screen.blogs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinecourses.R
import com.example.onlinecourses.common.BaseBlog
import com.example.onlinecourses.data.models.Blog
import com.example.onlinecourses.domain.CoursesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class BlogsViewModel @Inject constructor(
    private val repository: CoursesRepository
) : ViewModel() {
    private val _state = MutableStateFlow(BlogsState())
    val state get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(blogs = repository.getBlogs())
            }
        }
    }
}