package com.example.press_f_mobile.pages

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.press_f_mobile.R
import com.example.press_f_mobile.bottom_navigation.Page
import kotlinx.coroutines.delay

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun LoadingPage(
    navController: NavController
) {
    val isLoading = remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = true) {
        isLoading.value = true
        delay(700)
        navController.navigate(Page.SignIn.route) {
            popUpTo(Page.Loading.route) {
                inclusive = true
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = isLoading.value,
            enter = scaleIn(
                initialScale = 0.0f,
            ),
            content = {
                Image(
                    modifier = Modifier.height(260.dp),
                    contentScale = ContentScale.FillHeight,
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo"
                )
            }
        )
    }
}