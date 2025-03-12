package com.example.onlinecourses.ui.widgets

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.svg.SvgDecoder
import com.example.onlinecourses.data.models.Category

@Composable
fun CategoryCard(category: Category, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Row(
        Modifier
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .clickable { onClick() }
            .background(colorScheme.background, RoundedCornerShape(10.dp))
            .padding(17.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = category.name,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = colorScheme.onBackground
            )
            Text(
                text = category.coursesCount.toString() + " Courses",
                color = colorScheme.onBackground,
                fontSize = 12.sp,
                lineHeight = 12.sp
            )
        }
        Spacer(Modifier.width(30.dp))
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(category.icon)
                .decoderFactory(SvgDecoder.Factory())
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(28.dp)
        )
    }
}