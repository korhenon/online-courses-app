package com.example.onlinecourses.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onlinecourses.ui.screen.blogs.BlogsScreen
import com.example.onlinecourses.ui.screen.category.CategoryScreen
import com.example.onlinecourses.ui.screen.course.CourseScreen
import com.example.onlinecourses.ui.screen.home.HomeScreen
import com.example.onlinecourses.ui.screen.myCourses.MyCoursesScreen
import com.example.onlinecourses.ui.screen.profile.ProfileScreen
import com.example.onlinecourses.ui.screen.search.SearchScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destinations.Home) {
        composable<Destinations.Home> {
            HomeScreen(navController)
        }
        composable<Destinations.Category> {
            CategoryScreen(navController)
        }
        composable<Destinations.Search> {
            SearchScreen(navController)
        }
        composable<Destinations.MyCourses> {
            MyCoursesScreen(navController)
        }
        composable<Destinations.Course> {
            CourseScreen(navController)
        }
        composable<Destinations.Blogs> {
            BlogsScreen(navController)
        }
        composable<Destinations.Profile> {
            ProfileScreen(navController)
        }
    }
}