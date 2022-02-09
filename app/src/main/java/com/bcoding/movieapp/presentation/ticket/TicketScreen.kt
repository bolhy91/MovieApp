package com.bcoding.movieapp.presentation.ticket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bcoding.movieapp.ui.theme.MovieAppTheme
import com.bcoding.movieapp.ui.theme.background
import com.bcoding.movieapp.utils.TicketArray
import com.bcoding.movieapp.R
import com.bcoding.movieapp.ui.theme.primary


@Composable
fun TicketScreen() {
    MovieAppTheme {
        Surface(
            modifier = Modifier
                .background(background)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column {
                    TopBarSectionTicket()
                    Spacer(modifier = Modifier.height(20.dp))
                    TicketList(items = TicketArray.tickets)
                }
            }
        }
    }
}

@Composable
fun TicketList(items: List<Ticket>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp)
    ) {
        items.forEach {
            ticketItem(it)
        }
    }
}

@Composable
fun ticketItem(ticket: Ticket) {
    Card(
        modifier = Modifier.padding(top = 10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_ticket_bg),
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .padding(15.dp)
                .height(100.dp)
        ) {
            Text(
                ticket.title,
                style = MaterialTheme.typography.body2
                    .copy(fontWeight = FontWeight.SemiBold),
                color = primary,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Box(
                contentAlignment = Alignment.BottomCenter,
            ) {
                Column(
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(ticket.date, style = MaterialTheme.typography.h4, color = primary)
                    Text(ticket.category, style = MaterialTheme.typography.h4, color = primary)
                }
            }
        }
    }
}

@Composable
fun TopBarSectionTicket() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Ticket",
                style = MaterialTheme.typography.h1
            )
            Text(
                text = "|",
                style = MaterialTheme.typography.h1
            )
            Text(
                text = "Transaction",
                style = MaterialTheme.typography.h1.copy(fontWeight = FontWeight.Normal)
            )
        }
    }
}

data class Ticket(val title: String, val date: String, val category: String)


@Preview
@Composable
fun TicketScreenPreview() {
    TicketScreen()
}