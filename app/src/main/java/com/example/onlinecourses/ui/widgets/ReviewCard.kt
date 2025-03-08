package com.example.onlinecourses.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlinecourses.R
import com.example.onlinecourses.common.mark
import com.example.onlinecourses.data.models.Review
import com.example.onlinecourses.ui.theme.StarGray
import com.example.onlinecourses.ui.theme.StarYellow

@Composable
fun ReviewCard(review: Review, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = review.author,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 12.sp
        )
        Spacer(Modifier.height(5.dp))
        Text(
            text = "${review.date.month.name.take(1)}${
                review.date.month.name.drop(1).take(2).lowercase()
            } ${review.date.year}",
            fontSize = 10.sp,
            lineHeight = 10.sp
        )
        Spacer(Modifier.height(3.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            repeat(review.mark) {
                Icon(
                    painter = painterResource(R.drawable.star),
                    contentDescription = null,
                    tint = StarYellow,
                    modifier = Modifier.size(9.dp)
                )
            }
            repeat(5 - review.mark) {
                Icon(
                    painter = painterResource(R.drawable.star),
                    contentDescription = null,
                    tint = StarGray,
                    modifier = Modifier.size(9.dp)
                )
            }
        }
        Spacer(Modifier.height(10.dp))
        Text(text = review.text, fontSize = 12.sp, lineHeight = 12.sp)
    }
}