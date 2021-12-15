package com.bcoding.movieapp.presentation.home


import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
import com.google.accompanist.pager.*
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
        ) {
            InputSearch()
            MovieHorizontalPager()
        }
    }
}

@ExperimentalPagerApi
@Composable
fun MovieHorizontalPager() {
    val pagerState = rememberPagerState()
    Column(
        modifier = Modifier.fillMaxSize()
            .verticalScroll(rememberScrollState())

    ) {
        // Title
        Text(
            text = "Playing Now",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(top = 15.dp, bottom = 5.dp)
        )
        // Carousel
        HorizontalPager(
            count = 3,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 70.dp),
            modifier = Modifier.fillMaxSize()
        ) { page ->
            CardHomeMovie(modifier = Modifier
                .graphicsLayer {
                    // page = 0,1,2 (count)
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
                }, page)
        }

        // Indicators
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )
        Promos()
    }

}

@Composable
fun Promos() {
    val promos = listOf(
        R.drawable.promo1,
        R.drawable.promo2,
        R.drawable.promo3
    )
    Text(
        text = "Promo",
        style = MaterialTheme.typography.h1,
        modifier = Modifier.padding(top = 15.dp, bottom = 5.dp)
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        promos.forEach { promo ->
            Box(
                modifier = Modifier
                    .width(320.dp)
                    .height(120.dp)
                    .padding(5.dp)
            ) {
                Image(
                    painter = painterResource(id = promo),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun CardHomeMovie(modifier: Modifier, page: Int) {
    Card(
        modifier = modifier
            .width(210.dp)
            .height(280.dp)
            .shadow(8.dp, RoundedCornerShape(24.dp), clip = true)
            .background(Color.White)
    ) {
        when(page){
            0 -> Image(
                painter = painterResource(id = R.drawable.fondo),
                contentDescription = "fondo",
                modifier = Modifier,
                contentScale = ContentScale.FillWidth
            )
            1 -> Image(
                painter = painterResource(id = R.drawable.fondo2),
                contentDescription = "fondo",
                modifier = Modifier,
                contentScale = ContentScale.FillWidth
            )

            2 -> Image(
                painter = painterResource(id = R.drawable.fondo3),
                contentDescription = "fondo",
                modifier = Modifier,
                contentScale = ContentScale.FillWidth
            )
        }

    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}