package com.bcoding.movieapp.presentation.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.bcoding.movieapp.R
import com.bcoding.movieapp.ui.components.InputSearch
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import kotlin.math.absoluteValue

@ExperimentalPagerApi
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            InputSearch()
            MovieHorizontalPager()
        }
    }
}

@ExperimentalPagerApi
@Composable
fun MovieHorizontalPager() {
    Text(
        text = "Playing Now",
        style = MaterialTheme.typography.h1,
        modifier = Modifier.padding(top = 15.dp, bottom = 5.dp)
    )
    HorizontalPager(
        count = 3,
        contentPadding = PaddingValues(horizontal = 70.dp),
        modifier = Modifier.fillMaxSize()
    ) { page ->
        CardHomeMovie(modifier = Modifier
            .graphicsLayer {
                val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                // Animar scaleX + scaleY, entre 85% y 100%
                lerp(
                    start = 0.85f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                ).also { scale ->
                    scaleX = scale
                    scaleY = scale
                }

                alpha = lerp(
                    start = 0.5f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                )
            })
    }
}

@Preview()
@Composable
fun CardHomeMoviePreview() {
    CardHomeMovie(modifier = Modifier)
}

@Composable
fun CardHomeMovie(modifier: Modifier) {
    Card(
        modifier = modifier
            .width(210.dp)
            .height(280.dp)
            .shadow(8.dp, RoundedCornerShape(24.dp), clip = true)
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = "fondo",
            modifier = Modifier,
            contentScale = ContentScale.FillWidth
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    //HomeScreen()
}