package com.bcoding.movieapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bcoding.movieapp.MainScreenHomeTab
import com.bcoding.movieapp.presentation.home.HomeViewModel

@Composable
fun BottomBar(
    viewModel: HomeViewModel,
    selectedTab: MainScreenHomeTab
) {
    val tabs = MainScreenHomeTab.values()
    BottomNavigation(
        contentColor = Color.White,
        modifier = Modifier.padding(5.dp),
        elevation = 0.dp
    ) {
        tabs.forEach { item ->
            BottomNavigationItem(
                selected = item == selectedTab,
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title
                    )
                },
                alwaysShowLabel = true,
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                onClick = {
                    viewModel.selectTab(item)
                }
            )
        }
    }
}