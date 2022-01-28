package com.bcoding.movieapp.presentation.home

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.bcoding.movieapp.MainScreenHomeTab
import com.bcoding.movieapp.navigation.Destination
import com.bcoding.movieapp.presentation.profile.ProfileScreen
import com.bcoding.movieapp.presentation.ticket.TicketScreen
import com.bcoding.movieapp.ui.components.BottomBar
import com.bcoding.movieapp.ui.theme.background
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun HomeTabScreen(
    navController: NavHostController
) {
    val homeViewModel: HomeViewModel = hiltViewModel()
    val selectedTab by homeViewModel.selectedTab
    Surface(
        modifier = Modifier
            .background(background)
    ) {
        Scaffold(
            bottomBar = {
                BottomBar(
                    viewModel = homeViewModel,
                    selectedTab
                )
            },
        ) {
            Crossfade(selectedTab) { destination ->
                when (destination) {
                    MainScreenHomeTab.HOME -> {
                        val state = homeViewModel.state.value
                        HomeScreen(
                            navController = navController,
                            state = state,
                            onItemClick = { movieId ->
                                navController.navigate("${Destination.MovieDetail.route}/${movieId}")
                            }
                        )
                    }
                    MainScreenHomeTab.TICKET -> {
                        TicketScreen()
                    }
                    MainScreenHomeTab.PROFILE -> {
                        ProfileScreen()
                    }
                }
            }
        }
    }
}