package com.example.onlinecourses.ui.widgets

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onlinecourses.R
import com.example.onlinecourses.common.duration
import com.example.onlinecourses.common.mark
import com.example.onlinecourses.common.progressPercent
import com.example.onlinecourses.data.models.Course
import com.example.onlinecourses.data.models.InProgressCourse
import com.example.onlinecourses.ui.navigation.Destinations
import com.example.onlinecourses.ui.theme.OnlineCoursesTheme
import com.example.onlinecourses.ui.theme.ProgressGreen
import com.example.onlinecourses.ui.theme.StarYellow

@Composable
fun TopCourseCard(course: Course, navController: NavController) {
    Column(
        Modifier
            .width(230.dp)
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .background(colorScheme.background)
            .clip(RoundedCornerShape(10.dp))
            .clickable { navController.navigate(Destinations.Course(-1)) }
    ) {
        Image(
            painter = painterResource(course.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(133.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = course.name,
            fontSize = 18.sp,
            color = colorScheme.onBackground,
            modifier = Modifier.padding(horizontal = 5.dp)
        )
        Row(Modifier.padding(horizontal = 5.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "%.1f".format(course.mark()),
                fontSize = 12.sp,
                color = colorScheme.onBackground
            )
            Spacer(Modifier.width(4.dp))
            Image(painter = painterResource(R.drawable.star), contentDescription = null)
            Spacer(Modifier.width(23.dp))
            Text(
                text = "${course.learners}k Learners",
                fontSize = 12.sp,
                color = colorScheme.onBackground
            )
        }
        Spacer(Modifier.height(5.dp))
    }
}

@Composable
fun ListCourseCard(course: Course, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate(Destinations.Course(-1)) },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = course.name, fontSize = 18.sp)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "%.1f".format(course.mark()), fontSize = 12.sp)
                Spacer(Modifier.width(4.dp))
                Icon(
                    painter = painterResource(R.drawable.star),
                    contentDescription = null,
                    tint = StarYellow,
                    modifier = Modifier.size(14.dp)
                )
            }
            Text(text = "${course.learners}k Learners", fontSize = 12.sp)
        }
        Image(
            painter = painterResource(course.image),
            contentDescription = null,
            modifier = Modifier
                .size(85.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun InProgressCourseCard(course: InProgressCourse, navController: NavController) {
    Column(
        Modifier
            .fillMaxWidth()
            .shadow(5.dp, RoundedCornerShape(17.dp))
            .background(colorScheme.background)
            .clip(RoundedCornerShape(17.dp))
            .clickable { navController.navigate(Destinations.Course(-1)) }
    ) {
        Spacer(Modifier.height(10.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.weight(1f)) {
                Text(text = course.course.name, fontSize = 18.sp)
                Spacer(Modifier.height(5.dp))
                Text(
                    text = course.course.description,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 12.sp,
                    lineHeight = 12.sp
                )
                Spacer(Modifier.height(7.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(R.drawable.ic_clock), contentDescription = null)
                    Spacer(Modifier.width(10.dp))
                    Text(
                        text = "${((course.course.duration() - course.progress) / 60)} hours left",
                        fontSize = 12.sp
                    )
                }
            }
            Spacer(Modifier.width(50.dp))
            Box(Modifier.size(62.dp), contentAlignment = Alignment.Center) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawArc(
                        color = ProgressGreen,
                        startAngle = 90f,
                        sweepAngle = -360f * (course.progressPercent().toFloat() / 100f),
                        useCenter = false,
                        style = Stroke(
                            width = 20f,
                            cap = StrokeCap.Round
                        )
                    )
                }
                Text(text = "${course.progressPercent()}%", fontSize = 18.sp)
            }
        }
        Spacer(Modifier.height(5.dp))
        Box(
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(colorScheme.onBackground)
        )
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Start Learning",
                modifier = Modifier.padding(top = 9.dp, bottom = 14.dp),
                color = colorScheme.primary,
                fontSize = 18.sp
            )
        }
    }
}