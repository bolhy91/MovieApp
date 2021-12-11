package com.bcoding.movieapp.presentation.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProfileScreen() {
    Column() {
        Text(text = "Profile Screen")
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}