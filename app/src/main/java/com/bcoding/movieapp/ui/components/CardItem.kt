package com.bcoding.movieapp.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.bcoding.movieapp.R
import com.bcoding.movieapp.network.Api

@Composable
fun CardItem(
    title: String,
    posterPath: String?,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp)
            .shadow(8.dp, RoundedCornerShape(15.dp), clip = true)
            .clickable { },
    ) {
        Box(
            modifier = modifier
                .height((200..342).random().dp)
        ) {
            Log.i("POSTER PATH", posterPath.toString())
            Image(
                painter = rememberImagePainter(Api.getPosterPath(posterPath)),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxWidth()
            )
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black,
                            ),
                            startY = 300f
                        )
                    )
            ) {
            }
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = title,
                    style = TextStyle(color = Color.White, fontSize = 16.sp),
                )
            }
        }
    }

}

@Preview(name = "Card Item")
@Composable
fun CardItemPreview() {
    CardItem("Eternals", "/jtnfNzqZwN4E32FGGxx1YZaBWWf.jpg")
}