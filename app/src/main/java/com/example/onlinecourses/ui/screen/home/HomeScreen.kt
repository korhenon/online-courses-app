package com.example.onlinecourses.ui.screen.home

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.onlinecourses.R
import com.example.onlinecourses.ui.navigation.Destinations
import com.example.onlinecourses.ui.theme.HomeGradient1
import com.example.onlinecourses.ui.theme.HomeGradient2
import com.example.onlinecourses.ui.theme.OnlineCoursesTheme
import com.example.onlinecourses.ui.widgets.BottomNavigation
import com.example.onlinecourses.ui.widgets.CategoryCard
import com.example.onlinecourses.ui.widgets.PopularBlogCard
import com.example.onlinecourses.ui.widgets.TopCourseCard

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState {
        state.offers.size
    }
    Scaffold(modifier = Modifier, bottomBar = {
        BottomNavigation(navController)
    }) { paddingValues ->
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {
            Spacer(Modifier.height(5.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(IntrinsicSize.Min),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Hello ${state.name} !",
                    fontSize = 18.sp
                )
                IconButton(onClick = {
                    navController.navigate(Destinations.Search)
                }) {
                    Image(
                        painter = painterResource(R.drawable.ic_search),
                        contentDescription = null
                    )
                }
            }
            Spacer(Modifier.height(5.dp))
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.linearGradient(listOf(HomeGradient1, HomeGradient2)),
                        RoundedCornerShape(15.dp)
                    ), contentAlignment = Alignment.BottomCenter
            ) {
                HorizontalPager(pagerState, Modifier.fillMaxWidth()) { page ->
                    Row(
                        Modifier.padding(
                            start = 25.dp,
                            end = 29.dp,
                            top = 39.dp,
                            bottom = 43.dp
                        ),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(Modifier.weight(1f)) {
                            Text(
                                text = state.offers[page].title,
                                fontWeight = FontWeight.Medium,
                                fontSize = 18.sp,
                                color = colorScheme.onPrimary
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(
                                text = state.offers[page].text,
                                color = colorScheme.onPrimary,
                                fontSize = 14.sp
                            )
                            Spacer(Modifier.height(18.dp))
                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = colorScheme.background,
                                    contentColor = colorScheme.onSurface
                                ),
                                contentPadding = PaddingValues(vertical = 0.dp, horizontal = 20.dp),
                                modifier = Modifier.height(26.dp)
                            ) {
                                Text(text = state.offers[page].buttonText, fontSize = 12.sp)
                            }
                        }
                        Image(
                            painter = painterResource(state.offers[page].image),
                            contentDescription = null,
                            modifier = Modifier.size(130.dp)
                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.padding(bottom = 14.dp)
                ) {
                    repeat(state.offers.size) {
                        if (pagerState.currentPage == it) {
                            Box(
                                Modifier
                                    .size(6.dp)
                                    .background(colorScheme.onPrimary, CircleShape)
                            )
                        } else {
                            Box(
                                Modifier
                                    .size(6.dp)
                                    .border(1.dp, colorScheme.onPrimary, CircleShape)
                            )
                        }
                    }
                }
            }
            Spacer(Modifier.height(20.dp))
            Text(
                text = "Categories",
                fontSize = 18.sp,
                color = colorScheme.onSurface,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(Modifier.height(15.dp))
            Row(Modifier.horizontalScroll(rememberScrollState())) {
                Spacer(Modifier.width(20.dp))
                for (category in state.categories) {
                    CategoryCard(category, onClick = {
                        navController.navigate(Destinations.Category(category.name))
                    })
                    Spacer(Modifier.width(7.dp))
                }
                Spacer(Modifier.width(13.dp))
            }
            Spacer(Modifier.height(20.dp))
            Text(
                text = "Top Courses",
                fontSize = 18.sp,
                color = colorScheme.onSurface,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(Modifier.height(15.dp))
            Row(Modifier.horizontalScroll(rememberScrollState())) {
                Spacer(Modifier.width(20.dp))
                for (course in state.courses) {
                    TopCourseCard(course, navController)
                    Spacer(Modifier.width(15.dp))
                }
                Spacer(Modifier.width(5.dp))
            }

            Spacer(Modifier.height(20.dp))
            Text(
                text = "Popular blogs",
                fontSize = 18.sp,
                color = colorScheme.onSurface,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(Modifier.height(15.dp))
            Row(Modifier.horizontalScroll(rememberScrollState())) {
                Spacer(Modifier.width(20.dp))
                for (blog in state.blogs) {
                    PopularBlogCard(blog)
                    Spacer(Modifier.width(15.dp))
                }
                Spacer(Modifier.width(5.dp))
            }
            Spacer(Modifier.height(20.dp))
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    OnlineCoursesTheme {
        HomeScreen(rememberNavController())
    }
}