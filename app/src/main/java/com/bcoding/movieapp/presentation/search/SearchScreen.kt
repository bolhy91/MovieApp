package com.bcoding.movieapp.presentation.search

import android.widget.Space
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bcoding.movieapp.ui.components.InputSearch
import com.bcoding.movieapp.ui.theme.MovieAppTheme
import com.bcoding.movieapp.ui.theme.background
import com.bcoding.movieapp.ui.theme.primary700

@Composable
fun SearchScreen() {
    MovieAppTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(background)
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "Movie Browser",
                    style = MaterialTheme.typography.h1,
                    color = Color.White,
                    modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
                )
                InputSearch()
                Spacer(modifier = Modifier.height(15.dp))
                ListCategoryItem()
                ListCardItem()
            }
        }
    }
}

@Composable
fun ListCardItem() {

}

@Composable
fun ListCategoryItem() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .background(primary700)
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(modifier = Modifier
                .fillMaxWidth(0.5f)
                .clip(RoundedCornerShape(8.dp))
                .background(background)
                .padding(10.dp)
                .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Movies")
            }
            Spacer(modifier = Modifier.width(3.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(background)
                .padding(10.dp)
                .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Series")
            }
        }
    }
}

data class Category(
    val id: Int,
    val name: String
)

@Preview(name = "Search Screen")
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}