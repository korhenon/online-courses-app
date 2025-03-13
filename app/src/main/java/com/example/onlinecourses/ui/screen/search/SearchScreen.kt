package com.example.onlinecourses.ui.screen.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
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
import com.example.onlinecourses.ui.theme.OnlineCoursesTheme
import com.example.onlinecourses.ui.widgets.ListCourseCard
import com.example.onlinecourses.ui.widgets.NoInternet
import com.example.onlinecourses.ui.widgets.Spinner

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SearchScreen(navController: NavController, viewModel: SearchViewModel = hiltViewModel()) {
    val textFieldFocusRequester = remember { FocusRequester() }
    val textFieldInteractionSource = remember { MutableInteractionSource() }
    val textFieldDecorationBoxInteractionSource = remember { MutableInteractionSource() }
    val state by viewModel.state.collectAsState()
    Scaffold { innerPaddings ->
        Column(
            Modifier
                .padding(innerPaddings)
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
        ) {
            Spacer(Modifier.height(10.dp))
            BasicTextField(
                value = state.query,
                onValueChange = viewModel::updateQuery,
                interactionSource = textFieldInteractionSource,
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(textFieldFocusRequester),
                textStyle = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorScheme.onSurface
                ),
            ) { innerTextField ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorScheme.surface, RoundedCornerShape(4.dp))
                        .padding(vertical = 8.dp, horizontal = 12.dp)
                        .clickable(
                            interactionSource = textFieldDecorationBoxInteractionSource,
                            indication = null
                        ) {
                            textFieldFocusRequester.requestFocus()
                        },
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_arrow_left),
                            contentDescription = null,
                            modifier = Modifier.clickable {
                                navController.popBackStack()
                            }
                        )
                        Spacer(Modifier.width(18.dp))
                        innerTextField()
                    }
                    Image(
                        painter = painterResource(R.drawable.ic_search),
                        contentDescription = null
                    )
                }
            }
            Spacer(Modifier.height(19.dp))
            if (state.query == "") {
                Text(
                    text = "Popular Tags",
                    color = colorScheme.onSurface,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(Modifier.height(16.dp))
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    for (query in state.popularQueries) {
                        Box(
                            Modifier
                                .background(
                                    colorScheme.surfaceVariant,
                                    RoundedCornerShape(4.dp)
                                )
                                .padding(horizontal = 20.dp, vertical = 6.dp)
                                .clickable {
                                    viewModel.updateQuery(query)
                                }
                        ) {
                            Text(text = query, color = colorScheme.onSurface, fontSize = 18.sp)
                        }
                    }
                }
            } else {
                LazyColumn {
                    items(state.courses) {
                        ListCourseCard(it, navController)
                        Spacer(Modifier.height(15.dp))
                    }
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
private fun SearchScreenPreview() {
    OnlineCoursesTheme {
        SearchScreen(rememberNavController())
    }
}