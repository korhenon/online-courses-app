package com.example.onlinecourses.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.onlinecourses.R
import com.example.onlinecourses.common.BaseBlog
import com.example.onlinecourses.common.BaseCourse
import com.example.onlinecourses.data.models.Blog
import com.example.onlinecourses.data.models.Category
import com.example.onlinecourses.data.models.Offer
import com.example.onlinecourses.domain.CoursesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CoursesRepository
) : ViewModel() {
    private val _state = MutableStateFlow(
        HomeState(
            name = "Liza",
            offers = listOf(
                Offer(
                    title = "Secure the Online World",
                    text = "Lets get you started with Cyber Security",
                    buttonText = "Enroll for Free",
                    image = R.drawable.offer
                ),
                Offer(
                    title = "Secure the Online World",
                    text = "Lets get you started with Cyber Security",
                    buttonText = "Enroll for Free",
                    image = R.drawable.offer
                ),
            )
        )
    )

    val state get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    courses = repository.getCourses(),
                    categories = repository.getCategories(),
                    blogs = repository.getBlogs().take(3)
                )
            }
        }
    }

}