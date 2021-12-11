package com.bcoding.movieapp.navigation

import com.bcoding.movieapp.R

sealed class NavigationBottomItem(
    var route: String,
    var icon: Int,
    var title: String,
) {
    object Home: NavigationBottomItem("home", R.drawable.ic_home, "Home")
    object Ticket: NavigationBottomItem("ticket", R.drawable.ic_ticket, "Ticket")
    object Profile: NavigationBottomItem("profile", R.drawable.ic_person, "Profile")
}