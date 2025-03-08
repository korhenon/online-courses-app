package com.example.onlinecourses.ui.screen.myCourses

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.onlinecourses.R
import com.example.onlinecourses.ui.theme.OnlineCoursesTheme
import com.example.onlinecourses.ui.widgets.BottomNavigation
import com.example.onlinecourses.ui.widgets.InProgressCourseCard

@Composable
fun MyCoursesScreen(navController: NavController, viewModel: MyCoursesViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    Scaffold(bottomBar = {
        BottomNavigation(navController)
    }) { innerPaddings ->
        Column(
            Modifier
                .padding(innerPaddings)
                .fillMaxWidth()
                .padding(horizontal = 26.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "My Courses", fontSize = 18.sp, color = colorScheme.onSurface)
                Image(painter = painterResource(R.drawable.ic_search), contentDescription = null)
            }
            if (state.courses.isEmpty()) {
                Spacer(Modifier.height(75.dp))
                Image(painter = painterResource(R.drawable.no_courses), contentDescription = null)
                Spacer(Modifier.height(45.dp))
                Text(
                    text = "No Courses",
                    color = colorScheme.onSurface,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    text = "Looks like you have not enrolled for any course yet",
                    color = colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp
                )
                Spacer(Modifier.height(90.dp))
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 34.dp, vertical = 9.dp),
                ) {
                    Text(text = "Explore Courses", fontSize = 18.sp, fontWeight = FontWeight.Normal)
                }
            } else {
                LazyColumn(contentPadding = PaddingValues(top = 10.dp)) {
                    items(state.courses) {
                        InProgressCourseCard(it, navController)
                        Spacer(Modifier.height(20.dp))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun MyCoursesScreenPreview() {
    OnlineCoursesTheme {
        MyCoursesScreen(rememberNavController())
    }
}