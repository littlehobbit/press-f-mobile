package com.example.press_f_mobile.pages

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.press_f_mobile.R
import com.example.press_f_mobile.data.Event
import com.example.press_f_mobile.ui.theme.OrangeColor
import com.example.press_f_mobile.ui.theme.WhiteColor

@Composable
fun EventDetailedPage(
    navController: NavHostController,
    event: Event,
) {
    val eventState by remember {
        mutableStateOf(event)
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Box(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(id = eventState.imageId),
                contentDescription = event.title,
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        modifier = Modifier,
                        painter = painterResource(id = R.drawable.arrow_icon),
                        contentDescription = "back arrow",
                        tint = WhiteColor
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.notification_icon),
                    contentDescription = "notification",
                    tint = WhiteColor
                )
            }
        }

        Card(
            shape = RoundedCornerShape(
                topStart = CornerSize(20.dp),
                topEnd = CornerSize(20.dp),
                bottomEnd = CornerSize(0),
                bottomStart = CornerSize(0)
            ),
            elevation = 0.dp,
            modifier = Modifier
                .fillMaxSize()
                .offset(y = (-20).dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(30.dp)
            ) {
                Text(
                    text = event.title,
                    style = MaterialTheme.typography.h1
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.date_icon),
                            contentDescription = "date icon",
                            tint = OrangeColor
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = event.date,
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.body1,
                            color = OrangeColor
                        )
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = "${event.participantsNumber} собираются пойти",
                        style = MaterialTheme.typography.body1
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    textAlign = TextAlign.Justify,
                    text = event.fullDescription,
                    style = MaterialTheme.typography.body1
                )
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}