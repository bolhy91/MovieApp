package com.bcoding.movieapp.presentation.detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.bcoding.movieapp.R
import com.bcoding.movieapp.models.entities.Movie
import com.bcoding.movieapp.network.Api
import com.bcoding.movieapp.ui.theme.background
import com.bcoding.movieapp.ui.theme.borderColor
import com.bcoding.movieapp.ui.theme.iconColor
import kotlin.math.roundToInt

@Composable
fun MovieDetailScreen(
    movieId: Long,
    viewModel: MovieDetailViewModel,
    pressOnBack: () -> Unit
) {

    val movie: Movie? by remember(viewModel.state.value.movie) { mutableStateOf(viewModel.state.value.movie) }

    LaunchedEffect(key1 = movieId) {
        viewModel.getMovie(movieId = movieId)
    }

    Surface(
        modifier = Modifier
            .background(background)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column {
                TopBarSectionDetail(pressOnBack)
                BodySection(movie)
            }
        }
    }
}

@Composable
fun TopBarSectionDetail(pressOnBack: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 15.dp,
                end = 15.dp,
                top = 30.dp,
                bottom = 20.dp
            )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_left),
            contentDescription = "arrow left",
            tint = Color.White,
            modifier = Modifier
                .size(32.dp)
                .clickable { pressOnBack() }
        )
        Text(
            text = "MOVIE DETAIL",
            color = Color.White,
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(start = 5.dp)
        )
    }
}

@Composable
fun BodySection(movie: Movie?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Image and Category
        Row {
            Box(
                modifier = Modifier
                    .width(210.dp)
                    .height(280.dp)
            ) {
                Image(
                    painter = rememberImagePainter(
                        Api.getPosterPath(movie?.poster_path)
                    ),
                    contentDescription = "Movie detail",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .shadow(
                            5.dp,
                            shape = RoundedCornerShape(24.dp),
                            true
                        )
                        .fillMaxSize(),
                    alignment = Alignment.Center
                )
            }
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                CardAttributeSection(
                    "Popularity",
                    R.drawable.ic_category,
                    (movie?.popularity?.roundToInt()).toString()
                )
                movie?.release_date?.let {
                    CardAttributeSection(
                        "Release", R.drawable.ic_time,
                        it
                    )
                }
                CardAttributeSection("Rating", R.drawable.ic_star, (movie?.vote_average ?: 0f / 2f).toString())
            }
        }

        // Title
        movie?.title?.let {
            Text(
                text = it.uppercase(),
                color = Color.White,
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .padding(top = 25.dp, bottom = 10.dp)
            )
        }
        // border bottom
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(borderColor)
        )
        // Synopsis
        Text(
            text = "SYNOPSIS",
            color = Color.White,
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(top = 20.dp, bottom = 5.dp)
        )
        //Description
        Text(
            text = movie?.overview ?: "",
            color = Color.White,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(top = 10.dp, bottom = 5.dp)
        )
        // Button Watch Trailer
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            TextButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color.White)
                    .width(132.dp)
            ) {
                Text(
                    text = "Watch Trailer",
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center,
                    color = background
                )
            }
            TextButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color.White)
                    .width(132.dp)
            ) {
                Text(
                    text = "Get Ticket",
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center,
                    color = background
                )
            }
        }
    }
}

@Composable
fun CardAttributeSection(title: String, @DrawableRes icon: Int, value: String) {
    Box(
        modifier = Modifier
            .width(80.dp)
            .height(80.dp)
            .border(1.dp, borderColor, RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = title,
                color = borderColor,
                style = MaterialTheme.typography.h4
            )
            Text(
                text = value,
                color = Color.White,
                style = MaterialTheme.typography.caption
            )
        }
    }
}