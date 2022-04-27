package com.example.press_f_mobile.bottom_navigation

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.press_f_mobile.ui.theme.*

@Composable
fun BottomBar(
    navController: NavHostController,
    bottomBarState: MutableState<BottomBarState>
) {
    val screens = listOf(
        Page.News,
        Page.Events,
        Page.Rooms,
        Page.Booking
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    AnimatedVisibility(
        visible = bottomBarState.value.isVisible,
        enter = expandVertically(initialHeight = {0}),
        exit = shrinkVertically(targetHeight = {0}),
        content = {
            BottomNavigation(
                elevation = 13.dp,
                backgroundColor = WhiteColor,
                modifier = Modifier
                    .height(70.dp)
                    .background(WhiteColor)
            ) {
                screens.forEach { screen ->
                    AddBottomNavigationItem(
                        screen = screen,
                        currentDestination = currentDestination,
                        navController = navController
                    )
                }
            }
        }
    )
}

@Composable
fun RowScope.AddBottomNavigationItem(
    screen: Page,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        modifier = Modifier
            .height(70.dp),
        label = {
            Text(
                text = screen.title,
                style = MaterialTheme.typography.body2,
                softWrap = false
            )
        },
        icon = {
            Icon(
                modifier = Modifier.height(35.dp),
                painter = painterResource(id = screen.icon),
                contentDescription = screen.title
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        selectedContentColor = TillColor,
        unselectedContentColor = GrayColor,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findNode(Page.News.route)!!.id)
                launchSingleTop = true
            }
        }
    )
}