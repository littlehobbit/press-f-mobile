package com.example.press_f_mobile.bottom_navigation

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.press_f_mobile.data.Data
import com.example.press_f_mobile.data.Event
import com.example.press_f_mobile.pages.*
import com.example.press_f_mobile.top_bar.TopBarState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun CustomNavGraph(
    navController: NavHostController,
    topBarState: MutableState<TopBarState>,
    bottomBarState: MutableState<BottomBarState>,
    snackbarScope: CoroutineScope,
    scaffoldState: ScaffoldState
) {

    fun showSnackBar(message: String) {
        snackbarScope.launch {
            scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
            scaffoldState.snackbarHostState
                .showSnackbar(message)
        }
    }

    fun changeTopBarState(isVisible: Boolean = true, title: String = "-") {
        topBarState.value = topBarState.value.copy(
            isVisible = isVisible,
            pageTitle = title
        )
    }

    fun changeBottomBarState(isVisible: Boolean = true) {
        bottomBarState.value = bottomBarState.value.copy(
            isVisible = isVisible
        )
    }

    NavHost(
        navController = navController,
        startDestination = Page.Loading.route
    ) {
        composable(route = Page.Loading.route) {
            changeTopBarState(false)
            changeBottomBarState(false)
            LoadingPage(navController = navController)
        }

        composable(route = Page.SignIn.route) {
            changeTopBarState(false)
            changeBottomBarState(false)
            SignInPage(navController = navController)
        }

        composable(route = Page.SignUp.route) {
            changeTopBarState(false)
            changeBottomBarState(false)
            SignUpPage(navController = navController)
        }

        composable(route = Page.News.route) {
            changeTopBarState(true, Page.News.title)
            changeBottomBarState(true)
            NewsPage(navController = navController)
        }

        composable(route = Page.Events.route) {
            changeTopBarState(true, Page.Events.title)
            changeBottomBarState(true)
            EventsPage(
                navController = navController,
                showSnackBar = { message -> showSnackBar(message)}
            )
        }

        composable(
            route = Page.DetailedEvent.route,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) {
            changeTopBarState(false)
            changeBottomBarState(false)
            val eventId = it.arguments?.getInt("id") ?: -1

            EventDetailedPage(
                navController = navController,
                event = Data.events.value.find { event -> eventId == event.id } ?: Event()
            )
        }

        composable(route = Page.Rooms.route) {
            changeTopBarState(true, Page.Rooms.title)
            changeBottomBarState(true)
            RoomsPage(showSnackBar = { message -> showSnackBar(message)})
        }

        composable(route = Page.Booking.route) {
            changeTopBarState(true, Page.Booking.title)
            changeBottomBarState(true)
            BookingPage(
                showSnackBar = { message -> showSnackBar(message)}
            )
        }
    }


}

