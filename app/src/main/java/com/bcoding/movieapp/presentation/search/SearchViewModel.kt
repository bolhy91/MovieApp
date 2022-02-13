package com.bcoding.movieapp.presentation.search

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.bcoding.movieapp.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    val movieRepository: MovieRepository
): ViewModel() {
}