package com.bcoding.movieapp.navigation

sealed class Destination(val route: String) {
    object MovieDetail : Destination("MovieDetail") {
        const val routeWithArgument: String = "MovieDetail/{movieId}"
        const val argument0: String = "movieId"
    }
    object SearchView: Destination("searchView") {
        const val routeWithArgument: String = "searchView"
        const val argument0: String = ""
    }
}