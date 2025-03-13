package com.example.onlinecourses.ui.screen.category

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.toRoute
import com.example.onlinecourses.R
import com.example.onlinecourses.common.BaseCourse
import com.example.onlinecourses.data.models.Course
import com.example.onlinecourses.data.network.NetworkRepository
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
class CategoryViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: CoursesRepository
) : ViewModel() {
    private val route = savedStateHandle.toRoute<Destinations.Category>()
    private val _state = MutableStateFlow(
        CategoryState(
            category = route.category
        )
    )
    val state get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(internetState = InternetState(isLoading = true))
            }
            val courses = repository.getCoursesByCategory(route.id)
            _state.update {
                if (courses == null) {
                    it.copy(internetState = InternetState(isLoading = false, isNoInternet = true))
                } else {
                    it.copy(courses = courses)
                }
            }
        }
    }
}