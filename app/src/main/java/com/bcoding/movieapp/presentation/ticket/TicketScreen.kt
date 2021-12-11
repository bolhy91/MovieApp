package com.bcoding.movieapp.presentation.ticket

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TicketScreen() {
    Column() {
        Text(text = "Ticket Screen")
    }
}

@Preview
@Composable
fun TicketScreenPreview() {
    TicketScreen()
}