package com.example.onlinecourses.ui.screen.blogs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.onlinecourses.R
import com.example.onlinecourses.ui.theme.OnlineCoursesTheme
import com.example.onlinecourses.ui.widgets.BlogCard
import com.example.onlinecourses.ui.widgets.BottomNavigation

@Composable
fun BlogsScreen(navController: NavController, viewModel: BlogsViewModel = hiltViewModel()) {
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
                Text(text = "Blogs", fontSize = 18.sp, color = colorScheme.onSurface)
                Image(painter = painterResource(R.drawable.ic_search), contentDescription = null)
            }
            Spacer(Modifier.height(10.dp))
            LazyColumn {
                items(state.blogs.size / 2) {
                    val selection = state.blogs.drop(it * 2).take(2)
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        BlogCard(selection[0], modifier = Modifier.weight(1f))
                        if (selection.size > 1) {
                            BlogCard(selection[1], modifier = Modifier.weight(1f))
                        } else {
                            Spacer(Modifier.weight(1f))
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                }
            }
        }
    }
}

@Preview
@Composable
private fun BlogsScreenPreview() {
    OnlineCoursesTheme {
        BlogsScreen(rememberNavController())
    }
}