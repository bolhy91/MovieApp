package com.bcoding.movieapp.presentation.home


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.bcoding.movieapp.R
import com.bcoding.movieapp.models.entities.Movie
import com.bcoding.movieapp.models.network.PlayingNowState
import com.bcoding.movieapp.navigation.Destination
import com.bcoding.movieapp.network.Api
import com.bcoding.movieapp.ui.components.InputSearch
import com.bcoding.movieapp.ui.components.TopBarHome
import com.bcoding.movieapp.utils.rememberRandomSampleMovie
import com.google.accompanist.pager.*
import kotlin.math.absoluteValue

@ExperimentalPagerApi
@Composable
fun HomeScreen(
    navController: NavHostController,
    state: PlayingNowState,
    onItemClick: (Long) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Column(
            modifier = Modifier
        ) {
            TopBarHome()
            InputSearch(onInputClick = { navController.navigate(Destination.SearchView.route) })
            MovieHorizontalPager(state, onItemClick)
        }
    }
}

@ExperimentalPagerApi
@Composable
fun MovieHorizontalPager(
    state: PlayingNowState,
    onItemClick: (Long) -> Unit
) {
    val pagerState = rememberPagerState()
    Column(
        modifier = Modifier
            .fillMaxSize()
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
            CardHomeMovie(
                state,
                onItemClick = onItemClick,
                modifier = Modifier
                    .graphicsLayer {
                        // page = 0,1,2 (count)
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                        // Animate scaleX + scaleY, entre 85% y 100%
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
                    }
            )
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
                    .height(200.dp)
                    .padding(5.dp)
            ) {
                Image(
                    painter = painterResource(id = promo),
                    contentDescription = null,
                    modifier = Modifier
                        .width(320.dp)
                        .height(120.dp)
                )
            }
        }
    }
}

@Composable
fun CardHomeMovie(
    state: PlayingNowState,
    onItemClick: (Long) -> Unit,
    modifier: Modifier
) {
    if (state.movies.isNotEmpty()) {
        val movieRandom: Movie = rememberRandomSampleMovie(seeds = state.movies)
        Card(
            modifier = modifier
                .width(210.dp)
                .height(280.dp)
                .shadow(8.dp, RoundedCornerShape(24.dp), clip = true)
                .background(Color.White)
                .clickable { onItemClick(movieRandom.id) }
        ) {
            Image(
                painter = if (state.movies.isNotEmpty()) {
                    rememberImagePainter(Api.getPosterPath(movieRandom.poster_path))
                } else {
                    painterResource(id = R.drawable.fondo)
                },
                contentDescription = null,
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
    //HomeScreen()
}