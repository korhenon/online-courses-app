package com.example.onlinecourses.ui.screen.course

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.onlinecourses.R
import com.example.onlinecourses.common.duration
import com.example.onlinecourses.common.mark
import com.example.onlinecourses.ui.theme.OnlineCoursesTheme
import com.example.onlinecourses.ui.theme.StarGray
import com.example.onlinecourses.ui.theme.StarYellow
import com.example.onlinecourses.ui.widgets.ListCourseCard
import com.example.onlinecourses.ui.widgets.ModuleCard
import com.example.onlinecourses.ui.widgets.ReviewCard

@Composable
fun CourseScreen(navController: NavController, viewModel: CourseViewModel = hiltViewModel()) {
    var selectedTab by rememberSaveable { mutableIntStateOf(0) }
    val state by viewModel.state.collectAsState()
    Scaffold { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        ) {
            Spacer(Modifier.height(10.dp))
            Image(
                painterResource(R.drawable.ic_arrow_left),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 25.dp)
                    .clickable { navController.popBackStack() }
            )
            if (state.course != null) {
                val course = state.course!!
                Spacer(Modifier.height(14.dp))
                Image(
                    painter = painterResource(course.image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(285.dp)
                        .clip(RoundedCornerShape(15.dp)),
                    contentScale = ContentScale.Crop
                )
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp)
                ) {
                    Text(
                        text = course.name,
                        fontSize = 18.sp,
                        color = colorScheme.onBackground,
                        modifier = Modifier.padding(horizontal = 5.dp),
                        fontWeight = FontWeight.Medium
                    )
                    Row(
                        Modifier.padding(horizontal = 5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "%.1f".format(course.mark()),
                            fontSize = 12.sp,
                            color = colorScheme.onBackground
                        )
                        Spacer(Modifier.width(4.dp))
                        Icon(
                            painter = painterResource(R.drawable.star),
                            contentDescription = null,
                            tint = StarYellow
                        )
                        Spacer(Modifier.width(23.dp))
                        Text(
                            text = "${course.learners}k Learners",
                            fontSize = 12.sp,
                            color = colorScheme.onBackground
                        )
                    }
                    Spacer(Modifier.height(28.dp))
                    Row(
                        Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            Modifier
                                .width(IntrinsicSize.Max)
                                .clickable {
                                    selectedTab = 0
                                }) {
                            val textStyle = if (selectedTab == 0) TextStyle(
                                fontWeight = FontWeight.Medium,
                                color = colorScheme.primary
                            ) else TextStyle()
                            Text(text = "Overview", fontSize = 18.sp, style = textStyle)
                            Spacer(Modifier.height(3.dp))
                            Box(
                                Modifier
                                    .fillMaxWidth()
                                    .height(1.5.dp)
                                    .background(
                                        if (selectedTab == 0) colorScheme.primary else Color.Transparent,
                                        CircleShape
                                    )
                            )
                        }
                        Spacer(Modifier.weight(1f))
                        Column(
                            Modifier
                                .width(IntrinsicSize.Max)
                                .clickable {
                                    selectedTab = 1
                                }) {
                            val textStyle = if (selectedTab == 1) TextStyle(
                                fontWeight = FontWeight.Medium,
                                color = colorScheme.primary
                            ) else TextStyle()
                            Text(text = "Lectures", fontSize = 18.sp, style = textStyle)
                            Box(
                                Modifier
                                    .fillMaxWidth()
                                    .height(1.5.dp)
                                    .background(
                                        if (selectedTab == 1) colorScheme.primary else Color.Transparent,
                                        CircleShape
                                    )
                            )
                        }
                        Spacer(Modifier.weight(1f))
                        Column(
                            Modifier
                                .width(IntrinsicSize.Max)
                                .clickable {
                                    selectedTab = 2
                                }) {
                            val textStyle = if (selectedTab == 2) TextStyle(
                                fontWeight = FontWeight.Medium,
                                color = colorScheme.primary
                            ) else TextStyle()
                            Text(text = "Similar Courses", fontSize = 18.sp, style = textStyle)
                            Box(
                                Modifier
                                    .fillMaxWidth()
                                    .height(1.5.dp)
                                    .background(
                                        if (selectedTab == 2) colorScheme.primary else Color.Transparent,
                                        CircleShape
                                    )
                            )
                        }
                    }
                    when (selectedTab) {
                        0 -> {
                            Spacer(Modifier.height(16.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painter = painterResource(R.drawable.ic_clock_light),
                                    contentDescription = null
                                )
                                Spacer(Modifier.width(25.dp))
                                Text(text = "${course.duration() / 60} Hours")
                            }
                            if (course.hasCompletionCertificate) {
                                Spacer(Modifier.height(16.dp))
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Image(
                                        painter = painterResource(R.drawable.ic_certificate),
                                        contentDescription = null
                                    )
                                    Spacer(Modifier.width(25.dp))
                                    Text(text = "Completion Certificate")
                                }
                            }
                            Spacer(Modifier.height(16.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painter = painterResource(R.drawable.ic_level),
                                    contentDescription = null
                                )
                                Spacer(Modifier.width(25.dp))
                                Text(text = course.level)
                            }
                            Spacer(Modifier.height(37.dp))
                            Text(text = "What will I learn ?", fontSize = 18.sp)
                            Text(text = course.description, fontSize = 12.sp, lineHeight = 12.sp)
                            Spacer(Modifier.height(17.dp))
                            Text(text = "Ratings and Reviews", fontSize = 18.sp)
                            Spacer(Modifier.height(15.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(text = "%.1f".format(course.mark()), fontSize = 28.sp)
                                Spacer(Modifier.width(18.dp))
                                Column {
                                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                        val yellowStars = course.mark().toInt()
                                        repeat(yellowStars) {
                                            Icon(
                                                painter = painterResource(R.drawable.star),
                                                contentDescription = null,
                                                tint = StarYellow
                                            )
                                        }
                                        repeat(5 - yellowStars) {
                                            Icon(
                                                painter = painterResource(R.drawable.star),
                                                contentDescription = null,
                                                tint = StarGray
                                            )
                                        }
                                    }
                                    Spacer(Modifier.height(5.dp))
                                    Text(
                                        text = "${course.reviews.size} reviews",
                                        fontSize = 12.sp,
                                        lineHeight = 12.sp
                                    )
                                }
                            }
                            Spacer(Modifier.height(30.dp))
                            for (review in course.reviews) {
                                ReviewCard(review)
                                Spacer(Modifier.height(17.dp))
                            }
                        }

                        1 -> {
                            Spacer(Modifier.height(12.dp))
                            for (module in course.modules) {
                                ModuleCard(module)
                                Spacer(Modifier.height(12.dp))
                            }
                        }

                        else -> {
                            Spacer(Modifier.height(12.dp))
                            for (similarCourse in state.similar) {
                                ListCourseCard(similarCourse, navController)
                                Spacer(Modifier.height(15.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CourseScreenPreview() {
    OnlineCoursesTheme {
        CourseScreen(rememberNavController())
    }
}