package com.example.onlinecourses.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlinecourses.R
import com.example.onlinecourses.data.models.Blog

@Composable
fun PopularBlogCard(blog: Blog, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .width(230.dp)
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .background(colorScheme.background)
            .clip(RoundedCornerShape(10.dp))
    ) {
        Image(
            painter = painterResource(blog.image),
            contentDescription = null,
            modifier = Modifier.size(121.dp),
            contentScale = ContentScale.Crop
        )
        Column(
            Modifier
                .padding(start = 9.dp, top = 6.dp)
        ) {
            Text(
                text = blog.author,
                fontWeight = FontWeight.Light,
                fontSize = 10.sp,
                color = colorScheme.onBackground,
                lineHeight = 10.sp
            )
            Text(
                text = blog.title,
                fontSize = 12.sp,
                color = colorScheme.onBackground,
                lineHeight = 12.sp
            )
            Text(
                text = blog.text,
                fontSize = 8.sp,
                color = colorScheme.onBackground,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 8.sp
            )
        }
    }
}

@Composable
fun BlogCard(blog: Blog, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .background(colorScheme.background)
            .clip(RoundedCornerShape(10.dp))
    ) {
        Image(
            painter = painterResource(blog.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            contentScale = ContentScale.Crop
        )
        Column(Modifier
            .fillMaxWidth()
            .padding(horizontal = 9.dp)) {
            Spacer(Modifier.height(8.dp))
            Text(text = blog.tag, fontSize = 12.sp, lineHeight = 12.sp)
            Spacer(Modifier.height(5.dp))
            Text(
                text = blog.title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 12.sp
            )
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.ic_viewers),
                        contentDescription = null
                    )
                    Spacer(Modifier.width(6.dp))
                    Text(text = "${blog.viewers}k", fontSize = 10.sp, lineHeight = 10.sp)
                }
                Text(
                    text = "${blog.date.dayOfMonth} ${blog.date.month.name.take(1)}${
                        blog.date.month.name.drop(1).take(2).lowercase()
                    } ${blog.date.year}", fontSize = 10.sp, lineHeight = 10.sp
                )
            }
            Spacer(Modifier.height(12.dp))
        }

    }
}