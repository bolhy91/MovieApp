package com.bcoding.movieapp.presentation.search

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bcoding.movieapp.R
import com.bcoding.movieapp.models.entities.Serie
import com.bcoding.movieapp.ui.components.CardItem
import com.bcoding.movieapp.ui.components.InputSearch
import com.bcoding.movieapp.ui.components.StaggeredVerticalGrid
import com.bcoding.movieapp.ui.theme.MovieAppTheme
import com.bcoding.movieapp.ui.theme.background
import com.bcoding.movieapp.ui.theme.primary500
import com.bcoding.movieapp.ui.theme.primary700

@Composable
fun SearchScreen(
    navHostController: NavHostController,
    viewModel: SearchViewModel,
    pressOnBack: () -> Unit
) {

    val series: List<Serie> by remember(viewModel.state.value.series) {
        mutableStateOf(viewModel.state.value.series)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .verticalScroll(rememberScrollState())
        ) {
            TopBarSection {
                pressOnBack()
            }
            //InputSearch()
            Spacer(modifier = Modifier.height(20.dp))
            ListCategoryItem()
            ListCardItem(series)
        }
    }

}

@Composable
fun ListCardItem(items: List<Serie>) {
    StaggeredVerticalGrid(
        maxColumnWidth = 220.dp,
        modifier = Modifier
            .padding(5.dp)
    ) {
        items.forEach { item ->
            CardItem(item.original_name, item.poster_path)
        }
    }
}

@Composable
fun ListCategoryItem() {
    var selectedTab by remember {
        mutableStateOf(TabCategory.SERIES)
    }
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .background(primary700)
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { selectedTab = TabCategory.SERIES }
                    .background(if (selectedTab == TabCategory.SERIES) {
                        background
                    } else {
                        primary500
                    })
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Series")
            }
            Spacer(modifier = Modifier.width(3.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { selectedTab = TabCategory.MOVIES }
                    .background(if (selectedTab == TabCategory.MOVIES) {
                        background
                    } else {
                        primary500
                    })
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Movies")
            }
        }
    }
}

@Composable
fun TopBarSection(pressOnBack: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_left),
            contentDescription = "arrow left",
            tint = Color.White,
            modifier = Modifier
                .size(32.dp)
                .clickable { pressOnBack() }
        )
        Text(
            text = "Browser",
            style = MaterialTheme.typography.h1,
            color = Color.White,
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
        )
    }
}

enum class TabCategory{
    SERIES,
    MOVIES
}