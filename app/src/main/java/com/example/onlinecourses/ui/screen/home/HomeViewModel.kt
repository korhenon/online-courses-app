package com.example.onlinecourses.ui.screen.home

import androidx.lifecycle.ViewModel
import com.example.onlinecourses.R
import com.example.onlinecourses.common.BaseBlog
import com.example.onlinecourses.common.BaseCourse
import com.example.onlinecourses.data.models.Blog
import com.example.onlinecourses.data.models.Category
import com.example.onlinecourses.data.models.Offer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
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
            ),
            categories = listOf(
                Category(
                    name = "Cyber Security",
                    coursesCount = 145,
                    icon = R.drawable.category_security
                ),
                Category(
                    name = "Cyber Security",
                    coursesCount = 145,
                    icon = R.drawable.category_security
                ),
            ),
            courses = listOf(BaseCourse, BaseCourse, BaseCourse),
            blogs = listOf(BaseBlog, BaseBlog)
        )
    )

    val state get() = _state.asStateFlow()

}