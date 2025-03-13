package com.example.onlinecourses.ui.screen.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.onlinecourses.ui.widgets.ListCourseCard
import com.example.onlinecourses.ui.widgets.NoInternet
import com.example.onlinecourses.ui.widgets.Spinner

@Composable
fun CategoryScreen(navController: NavController, viewModel: CategoryViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    Scaffold { innerPaddings ->
        Column(
            Modifier
                .padding(innerPaddings)
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
        ) {
            Spacer(Modifier.height(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.ic_arrow_left),
                    contentDescription = null,
                    Modifier.clickable { navController.popBackStack() })
                Spacer(Modifier.width(12.dp))
                Text(text = state.category, fontSize = 18.sp, color = colorScheme.onSurface)
            }
            Spacer(Modifier.height(32.dp))
            LazyColumn {
                items(state.courses) {
                    ListCourseCard(it, navController)
                    Spacer(Modifier.height(15.dp))
                }
            }
        }
        if (state.internetState.isLoading) {
            Spinner()
        }
        if (state.internetState.isNoInternet) {
            NoInternet()
        }
    }
}

@Preview
@Composable
private fun CategoryScreenPreview() {
    OnlineCoursesTheme {
        CategoryScreen(rememberNavController())
    }
}