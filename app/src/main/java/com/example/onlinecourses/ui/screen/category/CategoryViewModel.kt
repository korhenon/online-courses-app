package com.example.onlinecourses.ui.screen.category

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.example.onlinecourses.R
import com.example.onlinecourses.common.BaseCourse
import com.example.onlinecourses.data.models.Course
import com.example.onlinecourses.ui.navigation.Destinations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _state = MutableStateFlow(CategoryState(
        savedStateHandle.toRoute<Destinations.Category>().category,
        listOf(BaseCourse, BaseCourse, BaseCourse)
    ))
    val state get() = _state.asStateFlow()
}