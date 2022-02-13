package com.bcoding.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bcoding.movieapp.navigation.Navigation
import com.bcoding.movieapp.ui.theme.MovieAppTheme
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