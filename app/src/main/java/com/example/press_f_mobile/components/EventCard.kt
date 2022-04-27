package com.example.press_f_mobile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.press_f_mobile.R
import com.example.press_f_mobile.data.Event
import com.example.press_f_mobile.ui.theme.OrangeColor
import com.example.press_f_mobile.ui.theme.TillColor

@Composable
fun EventCard(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    eventObj: Event,
    onClick: () -> Unit,
    setSelected: (() -> Boolean)? = null,
) {
    var selected by remember {
        mutableStateOf(eventObj.userIsParticipant)
    }

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        elevation = 10.dp,
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .clickable {
                navController.navigate(
                    "detailed-event/${eventObj.id}"
                )
            },
        ) {
            Image(
                modifier = Modifier
                    .height(190.dp)
                    .fillMaxWidth(),
                painter = painterResource(id = eventObj.imageId),
                contentDescription = eventObj.title,
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(
                    top = 20.dp,
                    start = 15.dp,
                    end = 15.dp,
                    bottom = 10.dp
                )
            ) {
                Text(
                    text = eventObj.title,
                    style = MaterialTheme.typography.h3
                )
                Spacer(modifier = Modifier.height(5.dp))
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
                        text = eventObj.date,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.body2,
                        color = OrangeColor
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = eventObj.description,
                    style = MaterialTheme.typography.body2
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "${eventObj.participantsNumber} собираются пойти",
                        style = MaterialTheme.typography.body2
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    CustomButton(
                        backgroundColor = if (selected) OrangeColor else TillColor,
                        text = if (selected) "- Отписатсья" else "+ Записаться",
                        shape = RoundedCornerShape(20.dp),
                        verticalPadding = 10.dp,
                        horizontalPadding = 15.dp,
                        onClickFunc = {
                            onClick()
                            selected = setSelected?.invoke() ?: false
                        }
                    )
                }
            }
        }
    }
}