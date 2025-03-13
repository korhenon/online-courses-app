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
import com.example.onlinecourses.ui.utils.InternetState
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
                it.copy(internetState = InternetState(isLoading = true))
            }
            val courses = repository.getCourses()
            val categories = repository.getCategories()
            val blogs = repository.getBlogs()
            _state.update {
                if (courses == null || categories == null || blogs == null) {
                    it.copy(internetState = InternetState(isLoading = false, isNoInternet = true))
                } else {
                    it.copy(
                        courses = courses.take(3),
                        categories = categories,
                        blogs = blogs.take(3),
                        internetState = InternetState(isLoading = false)
                    )
                }

            }
        }
    }

}