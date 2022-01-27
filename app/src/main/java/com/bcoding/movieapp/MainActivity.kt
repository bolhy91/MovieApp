package com.bcoding.movieapp

import android.os.Bundle
import android.util.Log
import android.view.WindowInsets
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bcoding.movieapp.navigation.Destination
import com.bcoding.movieapp.navigation.Navigation
import com.bcoding.movieapp.navigation.NavigationBottomItem
import com.bcoding.movieapp.presentation.detail.MovieDetailScreen
import com.bcoding.movieapp.presentation.detail.MovieDetailViewModel
import com.bcoding.movieapp.ui.components.BottomBar
import com.bcoding.movieapp.ui.components.TopBar
import com.bcoding.movieapp.ui.theme.MovieAppTheme
import com.bcoding.movieapp.ui.theme.background
import com.google.accompanist.insets.ProvideWindowInsets
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
fun MainScreen() {
    val navController = rememberNavController()
    MovieAppTheme {
        ProvideWindowInsets {
            HomeScreenTab(navController = navController)
        }
        /**Column(modifier = Modifier
        .verticalScroll(rememberScrollState())) {
        // TopBar
        TopBar()
        // Navigation
        Navigation(navController = navController)
        //Bottom Menu
        BottomBar(navController = navController)
        }*/
        /**Column(modifier = Modifier
        .verticalScroll(rememberScrollState())) {
        // TopBar
        TopBar()
        // Navigation
        Navigation(navController = navController)
        //Bottom Menu
        BottomBar(navController = navController)
        }*/
    }
}

@ExperimentalPagerApi
@Composable
fun HomeScreenTab(navController: NavHostController) {
    Navigation(navController = navController)
}

@Immutable
enum class MainScreenHomeTab(
    val title: String,
    val icon: Int
) {
    HOME("Home", R.drawable.ic_home),
    TICKET("Ticket", R.drawable.ic_ticket),
    PROFILE("Profile", R.drawable.ic_person);
}

@Preview
@Composable
fun MainScreenPreview() {
    //MainScreen()
}