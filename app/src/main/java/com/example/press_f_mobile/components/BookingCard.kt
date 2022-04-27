package com.example.press_f_mobile.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.press_f_mobile.R
import com.example.press_f_mobile.ui.theme.BlackColor
import com.example.press_f_mobile.ui.theme.OrangeColor

@Composable
fun BookingCard(
    modifier: Modifier = Modifier,
    bookingNumber: String = "-",
    roomNumber: String = "-",
    startTime: String = "--:-- --.--.----",
    endTime: String = "--:-- --.--.----",
    onButtonClick: () -> Unit
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        elevation = 10.dp,
    ) {
        Column(
            modifier = Modifier.padding(
                top = 20.dp,
                start = 15.dp,
                end = 15.dp,
                bottom = 10.dp
            )
        ) {
            Text(
                text = "Заказ №${bookingNumber}",
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Бронь комнаты №${roomNumber}",
                style = MaterialTheme.typography.h4
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "С $startTime",
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.body2,
                )
                Spacer(modifier = Modifier.width(30.dp))
                Text(
                    text = "До $endTime",
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.body2,
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
                .padding(10.dp)
                .border(border = BorderStroke(1.dp, BlackColor), shape = RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth,
                    painter = painterResource(id = R.drawable.shtrih),
                    contentDescription = "shtrih"
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                CustomButton(
                    backgroundColor = OrangeColor,
                    text = "Напомнить о заказе",
                    shape = RoundedCornerShape(20.dp),
                    verticalPadding = 10.dp,
                    horizontalPadding = 15.dp,
                    onClickFunc = onButtonClick
                )
            }
        }
    }
}
