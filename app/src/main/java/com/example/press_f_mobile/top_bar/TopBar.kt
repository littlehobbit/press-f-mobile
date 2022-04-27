package com.example.press_f_mobile.top_bar

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.press_f_mobile.R
import com.example.press_f_mobile.top_bar.TopBarState
import com.example.press_f_mobile.ui.theme.BlackColor
import com.example.press_f_mobile.ui.theme.OrangeColor
import com.example.press_f_mobile.ui.theme.WhiteColor

@Composable
fun TopBar(
    topBarState : MutableState<TopBarState>
) {
    AnimatedVisibility(
        visible = topBarState.value.isVisible,
        enter = expandVertically(initialHeight = {0}),
        exit = shrinkVertically(targetHeight = {0}),
        content = {
            TopAppBar(
                elevation = 10.dp,
                contentPadding = PaddingValues(
                    horizontal = 10.dp,
                    vertical = 5.dp
                ),
                backgroundColor = WhiteColor,
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = topBarState.value.pageTitle,
                        style = MaterialTheme.typography.h2,
                        color = BlackColor
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    Icon(
                        modifier = Modifier.align(Alignment.CenterEnd),
                        painter = painterResource(id = R.drawable.notification_icon),
                        contentDescription = "notifications",
                        tint = OrangeColor
                    )
                }
            }
        }
    )
}