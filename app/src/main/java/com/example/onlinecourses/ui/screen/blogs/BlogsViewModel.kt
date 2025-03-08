package com.example.onlinecourses.ui.screen.blogs

import androidx.lifecycle.ViewModel
import com.example.onlinecourses.R
import com.example.onlinecourses.common.BaseBlog
import com.example.onlinecourses.data.models.Blog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class BlogsViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(
        BlogsState(
            listOf(
                BaseBlog,
                BaseBlog,
                BaseBlog,
                BaseBlog,
                BaseBlog,
                BaseBlog,
                BaseBlog,
                BaseBlog,
                BaseBlog,
                BaseBlog,
                BaseBlog,
                BaseBlog,
                BaseBlog,
                BaseBlog,
                BaseBlog
            )
        )
    )
    val state get() = _state.asStateFlow()
}