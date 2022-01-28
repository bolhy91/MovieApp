package com.bcoding.movieapp.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bcoding.movieapp.ui.components.TopBarDefault
import com.bcoding.movieapp.ui.theme.MovieAppTheme
import com.bcoding.movieapp.ui.theme.background
import com.bcoding.movieapp.ui.theme.primary500

@Composable
fun ProfileScreen() {
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
                    TopBarDefault()
                    val accounts = AccountItemList.values()
                    val others = OtherItemList.values()
                    Column {
                        // Accounts
                        Text(
                            text = "Account",
                            style = MaterialTheme.typography.h1.copy(fontWeight = FontWeight.Bold),
                            modifier = Modifier.padding(15.dp)
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(primary500)
                        ) {
                            Column(
                                modifier = Modifier.padding(15.dp),
                                verticalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                accounts.forEach { item ->
                                    Text(text = item.title, style = MaterialTheme.typography.body1)
                                }
                            }
                        }

                        // Others
                        Text(
                            text = "Other",
                            style = MaterialTheme.typography.h1.copy(fontWeight = FontWeight.Bold),
                            modifier = Modifier.padding(15.dp)
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(primary500)
                        ) {
                            Column(
                                modifier = Modifier.padding(15.dp),
                                verticalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                others.forEach { item ->
                                    Text(text = item.title, style = MaterialTheme.typography.body1)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Immutable
enum class AccountItemList(
    val title: String,
    val route: String
) {
    PROFILE("Profile", "profile"),
    PAYMENT("Payment", "payment"),
    WISHLIST("Wishlist", "wishlist");
}


@Immutable
enum class OtherItemList(
    val title: String,
    val route: String
) {
    HELP("Help", "help"),
    ABOUT("About", "about"),
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}