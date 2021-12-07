package com.bcoding.movieapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bcoding.movieapp.ui.components.InputSearch
import com.bcoding.movieapp.ui.components.TopBar
import com.bcoding.movieapp.ui.theme.MovieAppTheme
import com.bcoding.movieapp.ui.theme.background

@Composable
fun HomeScreen() {
    MovieAppTheme {
        Surface(
            modifier = Modifier
                .background(background)
                .padding(20.dp)
        ) {
            Scaffold(
                topBar = { TopBar() }
            ) {
                InputSearch()
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}