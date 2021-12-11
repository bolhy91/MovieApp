package com.bcoding.movieapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bcoding.movieapp.navigation.NavigationBottomItem

@Composable
fun BottomBar(navController: NavController) {
    val items = listOf(
        NavigationBottomItem.Home,
        NavigationBottomItem.Ticket,
        NavigationBottomItem.Profile,
    )

    BottomNavigation(
        contentColor = Color.White,
        modifier = Modifier.padding(15.dp),
        elevation = 0.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon), 
                        contentDescription = item.title)
                },
                alwaysShowLabel = true,
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                onClick = {
                    navController.navigate(item.route){
                        // Para evitar acumular una gran cantidad de destinos en la pila
                        // posterior a medida que los usuarios seleccionan elementos
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route = route){
                                saveState = true
                            }
                        }
                        //Evita múltiples copias del mismo destino cuando
                        //volver a seleccionar el mismo artículo
                        launchSingleTop = true
                        // restaurar el estado al volver a seleccionar un elemento previamente seleccionado
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    //BottomBar()
}