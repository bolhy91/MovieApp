package com.bcoding.movieapp.navigation

sealed class Destination(val route: String) {
    object MovieDetail : Destination("MovieDetail") {
        const val routeWithArgument: String = "MovieDetail/{movieId}"
        const val argument0: String = "movieId"
    }
}