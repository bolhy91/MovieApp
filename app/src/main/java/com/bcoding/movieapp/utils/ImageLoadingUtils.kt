package com.bcoding.movieapp.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.bcoding.movieapp.models.entities.Movie
import com.bcoding.movieapp.network.Api

//when (page) {
//    0 -> Image(
//    painter = if (state.movies.isNotEmpty()) {
//        rememberImagePainter(Api.getPosterPath(state.movies[0].poster_path))
//    } else {
//        painterResource(id = R.drawable.fondo)
//    },
//    contentDescription = null,
//    modifier = Modifier,
//    contentScale = ContentScale.FillWidth
//    )
//    1 -> Image(
//    painter = if (state.movies.isNotEmpty()) {
//        rememberImagePainter(Api.getPosterPath(state.movies[1].poster_path))
//    } else {
//        painterResource(id = R.drawable.fondo)
//    },
//    contentDescription = null,
//    modifier = Modifier,
//    contentScale = ContentScale.FillWidth
//    )
//
//    2 -> Image(
//    painter = if (state.movies.isNotEmpty()) {
//        rememberImagePainter(Api.getPosterPath(state.movies[2].poster_path))
//    } else {
//        painterResource(id = R.drawable.fondo)
//    },
//    contentDescription = null,
//    modifier = Modifier,
//    contentScale = ContentScale.FillWidth
//    )
//}

fun randomSampleMovie(
    seeds: List<Movie>
): Movie {
    val seed = seeds.random()
    return seed
}

/**
 * Remember a URL generate by [rememberRandomSampleMovie].
 */
@Composable
fun rememberRandomSampleMovie(
    seeds: List<Movie>,
): Movie = remember { randomSampleMovie(seeds) }