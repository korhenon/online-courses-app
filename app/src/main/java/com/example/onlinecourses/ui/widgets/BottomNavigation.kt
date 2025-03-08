package com.example.onlinecourses.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onlinecourses.R
import com.example.onlinecourses.ui.navigation.Destinations

@Composable
fun BottomNavigation(navController: NavController, modifier: Modifier = Modifier) {
    val currentRoute = navController.currentDestination!!.route!!.split(".").last()
    val homeModifier = if (currentRoute == "Home") Modifier else Modifier.clickable {
        navController.navigate(Destinations.Home)
    }
    val myCoursesModifier = if (currentRoute == "MyCourses") Modifier else Modifier.clickable {
        navController.navigate(Destinations.MyCourses)
    }
    val blogsModifier = if (currentRoute == "Blogs") Modifier else Modifier.clickable {
        navController.navigate(Destinations.Blogs)
    }
    val profileModifier = if (currentRoute == "Profile") Modifier else Modifier.clickable {
        navController.navigate(Destinations.Profile)
    }

    Row(
        Modifier
            .fillMaxWidth()
            .background(colorScheme.background)
            .padding(horizontal = 40.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = homeModifier
        ) {
            Image(
                painter = painterResource(id = if (currentRoute == "Home") R.drawable.ic_nav_s_home else R.drawable.ic_nav_ns_home),
                contentDescription = null
            )
            if (currentRoute == "Home") {
                Text(
                    text = "Home",
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp,
                    color = colorScheme.primary
                )
            } else {
                Text(text = "Home", fontSize = 10.sp, color = colorScheme.onBackground)
            }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = myCoursesModifier) {
            Image(
                painter = painterResource(id = if (currentRoute == "MyCourses") R.drawable.ic_nav_s_my_courses else R.drawable.ic_nav_ns_my_courses),
                contentDescription = null
            )
            if (currentRoute == "MyCourses") {
                Text(
                    text = "My Courses",
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp,
                    color = colorScheme.primary
                )
            } else {
                Text(text = "My Courses", fontSize = 10.sp, color = colorScheme.onBackground)
            }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = blogsModifier) {
            Image(
                painter = painterResource(id = if (currentRoute == "Blogs") R.drawable.ic_nav_s_blogs else R.drawable.ic_nav_ns_blogs),
                contentDescription = null
            )
            if (currentRoute == "Blogs") {
                Text(
                    text = "Blogs",
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp,
                    color = colorScheme.primary
                )
            } else {
                Text(text = "Blogs", fontSize = 10.sp, color = colorScheme.onBackground)
            }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = profileModifier) {
            Image(
                painter = painterResource(id = if (currentRoute == "Profile") R.drawable.ic_nav_s_profile else R.drawable.ic_nav_ns_profile),
                contentDescription = null,
                Modifier.size(32.dp)
            )
            if (currentRoute == "Profile") {
                Text(
                    text = "My Profile",
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp,
                    color = colorScheme.primary
                )
            } else {
                Text(text = "My Profile", fontSize = 10.sp, color = colorScheme.onBackground)
            }
        }
    }
}