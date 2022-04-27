package com.example.press_f_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.press_f_mobile.bottom_navigation.BottomBar
import com.example.press_f_mobile.bottom_navigation.BottomBarState
import com.example.press_f_mobile.bottom_navigation.CustomNavGraph
import com.example.press_f_mobile.top_bar.TopBar
import com.example.press_f_mobile.top_bar.TopBarState
import com.example.press_f_mobile.ui.theme.Press_F_mobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val bottomBarState = remember { (mutableStateOf(BottomBarState())) }
            val topBarState = remember { (mutableStateOf(TopBarState())) }
            val scaffoldState = rememberScaffoldState()
            val snackbarScope = rememberCoroutineScope()

            Press_F_mobileTheme {
                // A surface container using the 'background' color from the theme

                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        TopBar(topBarState = topBarState)
                    },
                    bottomBar = {
                        BottomBar(
                            navController = navController,
                            bottomBarState = bottomBarState
                        )
                    },
                    content = {
                        Box(
                            modifier = Modifier
                                .padding(
                                    top = it.calculateTopPadding(),
                                    bottom = it.calculateBottomPadding()
                                )
                                .fillMaxSize()
                        ) {
                            CustomNavGraph(
                                navController = navController,
                                bottomBarState = bottomBarState,
                                topBarState = topBarState,
                                snackbarScope = snackbarScope,
                                scaffoldState = scaffoldState
                            )
                        }
                    }
                )
            }
        }
    }
}