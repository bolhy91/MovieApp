package com.bcoding.movieapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcoding.movieapp.R
import com.bcoding.movieapp.ui.theme.caption
import com.bcoding.movieapp.ui.theme.iconColor

@Composable
fun TopBar() {
    Box(modifier = Modifier.fillMaxWidth().padding(15.dp)){
        TopAppBar(
            title = {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column {
                        Text(
                            buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                ) {
                                    append("Hello ")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Normal
                                    )
                                ) {
                                    append("Bolivar")
                                }
                            },
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_map),
                                contentDescription = "location",
                                tint = iconColor,
                                modifier = Modifier.size(24.dp),
                            )
                            Text(
                                text = "New York City",
                                style = MaterialTheme.typography.body2,
                                color = caption
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_arrow_down),
                                contentDescription = "arrow down",
                                tint = iconColor,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }

                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "profile",
                        modifier = Modifier.size(56.dp)
                    )
                }
            },
            elevation = 0.dp,
            modifier = Modifier
                .height(70.dp)
        )
    }
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}