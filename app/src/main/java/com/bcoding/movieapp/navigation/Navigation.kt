package com.bcoding.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bcoding.movieapp.presentation.home.HomeScreen
import com.bcoding.movieapp.presentation.profile.ProfileScreen
import com.bcoding.movieapp.presentation.ticket.TicketScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationBottomItem.Home.route) {
        homeScreen()

        ticketScreen()

        profileScreen()
    }
}

@ExperimentalPagerApi
fun NavGraphBuilder.homeScreen(){
    composable(route = NavigationBottomItem.Home.route){
        HomeScreen()
    }
}


fun NavGraphBuilder.ticketScreen(){
    composable(route = NavigationBottomItem.Ticket.route){
        TicketScreen()
    }
}


fun NavGraphBuilder.profileScreen(){
    composable(route = NavigationBottomItem.Profile.route){
        ProfileScreen()
    }
}