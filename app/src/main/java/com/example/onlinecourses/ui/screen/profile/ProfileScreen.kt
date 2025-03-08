package com.example.onlinecourses.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.onlinecourses.R
import com.example.onlinecourses.ui.theme.OnlineCoursesTheme
import com.example.onlinecourses.ui.widgets.BottomNavigation

@Composable
fun ProfileScreen(navController: NavController, viewModel: ProfileViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    Scaffold(bottomBar = {
        BottomNavigation(navController)
    }) { innerPaddings ->
        Column(
            Modifier
                .padding(innerPaddings)
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
        ) {
            Spacer(Modifier.height(10.dp))
            Row {
                Image(
                    painter = painterResource(R.drawable.ic_arrow_left),
                    contentDescription = null,
                    modifier = Modifier.clickable { navController.popBackStack() })
                Spacer(Modifier.width(20.dp))
                Text(text = "My Profile", fontSize = 18.sp)
            }
            Spacer(Modifier.height(42.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(45.dp)
                        .background(colorScheme.surfaceVariant, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = state.name.take(1), fontSize = 24.sp)
                }
                Spacer(Modifier.width(12.dp))
                Column {
                    Text(
                        text = state.name,
                        fontSize = 12.sp,
                        lineHeight = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(Modifier.height(2.dp))
                    Text(text = state.email, fontSize = 12.sp, lineHeight = 12.sp)
                }
            }
            Spacer(Modifier.height(35.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.ic_refer_and_learn),
                    contentDescription = null
                )
                Spacer(Modifier.width(18.dp))
                Text(text = "Refer and Learn", fontSize = 18.sp)
            }
            Spacer(Modifier.height(23.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.ic_connected_accounts),
                    contentDescription = null
                )
                Spacer(Modifier.width(18.dp))
                Text(text = "Connected Accounts", fontSize = 18.sp)
            }
            Spacer(Modifier.height(23.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.ic_rate_app),
                    contentDescription = null
                )
                Spacer(Modifier.width(18.dp))
                Text(text = "Rate App", fontSize = 18.sp)
            }
            Spacer(Modifier.height(23.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.ic_share_app),
                    contentDescription = null
                )
                Spacer(Modifier.width(18.dp))
                Text(text = "Share App", fontSize = 18.sp)
            }
            Spacer(Modifier.height(23.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.ic_privacy_policy),
                    contentDescription = null
                )
                Spacer(Modifier.width(18.dp))
                Text(text = "Privacy Policy", fontSize = 18.sp)
            }
            Spacer(Modifier.height(23.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.ic_sign_out),
                    contentDescription = null
                )
                Spacer(Modifier.width(18.dp))
                Text(text = "Sign out", fontSize = 18.sp)
            }
        }
    }
}

@Preview
@Composable
private fun ProfileScreenPreview() {
    OnlineCoursesTheme {
        ProfileScreen(rememberNavController())
    }
}