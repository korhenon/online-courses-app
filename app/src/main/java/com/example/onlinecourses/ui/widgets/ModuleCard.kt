package com.example.onlinecourses.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlinecourses.R
import com.example.onlinecourses.data.models.Module

@Composable
fun ModuleCard(module: Module, modifier: Modifier = Modifier) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }
    Column(
        Modifier
            .fillMaxWidth()
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .background(colorScheme.background)
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Lesson ${module.number}", fontSize = 12.sp, fontWeight = FontWeight.Medium)
            Image(
                painter = painterResource(R.drawable.ic_expand),
                contentDescription = null,
                modifier = Modifier
                    .rotate(if (isExpanded) 180f else 0f)
                    .clickable { isExpanded = !isExpanded }
            )
        }
        Text(text = module.name, fontSize = 18.sp, fontWeight = FontWeight.Medium)
        if (isExpanded) {
            Spacer(Modifier.height(6.dp))
            Column(verticalArrangement = Arrangement.spacedBy(9.dp)) {
                for (lecture in module.lectures) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(R.drawable.ic_nav_ns_my_courses),
                            contentDescription = null,
                            Modifier.size(16.dp)
                        )
                        Spacer(Modifier.width(9.dp))
                        Text(text = lecture.name, fontSize = 12.sp, lineHeight = 12.sp)
                    }
                }
            }
        }
    }
}