package com.bcoding.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.bcoding.movieapp.navigation.Navigation
import com.bcoding.movieapp.ui.components.BottomBar
import com.bcoding.movieapp.ui.components.TopBar
import com.bcoding.movieapp.ui.theme.MovieAppTheme
import com.bcoding.movieapp.ui.theme.background
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@ExperimentalPagerApi
@Composable
private fun MainScreen() {
    val navController = rememberNavController()
    MovieAppTheme {
        Surface(
            modifier = Modifier
                .background(background)
        ) {
            Scaffold(
                topBar = { TopBar() },
                bottomBar = { BottomBar(navController = navController) }
            ){
                Navigation(navController = navController)
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    //MainScreen()
}