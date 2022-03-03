package com.bcoding.movieapp.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.bcoding.movieapp.presentation.detail.MovieDetailScreen
import com.bcoding.movieapp.presentation.detail.MovieDetailViewModel
import com.bcoding.movieapp.presentation.home.HomeTabScreen
import com.bcoding.movieapp.presentation.search.SearchScreen
import com.bcoding.movieapp.presentation.search.SearchViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationBottomItem.Home.route) {
        // Navigation Bottom
        homeScreenTab(navController = navController)
        movieDetail(navController = navController)
        searchView(navController)
    }
}

@ExperimentalPagerApi
fun NavGraphBuilder.homeScreenTab(navController: NavHostController) {
    composable(route = NavigationBottomItem.Home.route) {
        HomeTabScreen(navController = navController)
    }
}

// Details Movie
fun NavGraphBuilder.movieDetail(navController: NavHostController) {
    composable(
        route = Destination.MovieDetail.routeWithArgument,
        arguments = listOf(
            navArgument(Destination.MovieDetail.argument0) {
                type = NavType.LongType
            }
        )
    ) { backStackEntry ->
        val movieId = backStackEntry.arguments?.getLong(Destination.MovieDetail.argument0)
            ?: return@composable
        Log.i("MOVIEID: ", movieId.toString())
        val movieDetailViewModel: MovieDetailViewModel = hiltViewModel()
        MovieDetailScreen(movieId = movieId, movieDetailViewModel) { navController.navigateUp() }
    }
}

// Search View
fun NavGraphBuilder.searchView(navController: NavHostController) {
    composable(route = Destination.SearchView.route) {
        val searchViewModel: SearchViewModel = hiltViewModel()
        SearchScreen(
            navHostController = navController,
            viewModel = searchViewModel,
            pressOnBack = { navController.navigateUp() }
        )
    }
}