package com.example.press_f_mobile.components

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.press_f_mobile.data.Room
import com.example.press_f_mobile.ui.theme.*

@Composable
fun RoomCard(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit,
    setSelected: (() -> Boolean)? = null,
    room: Room
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        elevation = 10.dp,
    ) {
        var selected by remember {
            mutableStateOf(room.isBooked)
        }

        Column(
            modifier = Modifier
                .padding(
                    top = 20.dp,
                    start = 15.dp,
                    end = 15.dp,
                    bottom = 10.dp
                )
                .fillMaxSize()
        ) {
            Text(
                text = "Комната №${room.roomNumber}",
                style = MaterialTheme.typography.h2
            )
            Spacer(modifier = Modifier.height(5.dp))
            for (item in room.inventory) {
                Text(
                    text = item,
                    style = MaterialTheme.typography.body1
                )
            }

            CustomButton(
                modifier = Modifier
                    .align(End)
                    .width(180.dp),
                contentColor = if (selected) WhiteColor else BlackColor,
                backgroundColor = if (selected) OrangeColor else YellowColor,
                text = if (selected) "Ожидает подтверждения" else "Забронировать",
                shape = RoundedCornerShape(5.dp),
                verticalPadding = 10.dp,
                horizontalPadding = 15.dp,
                onClickFunc = {
                    onButtonClick()
                    selected = setSelected?.invoke() ?: false
                }
            )
        }

    }
}