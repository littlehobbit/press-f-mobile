package com.example.press_f_mobile.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.press_f_mobile.components.BookingCard
import com.example.press_f_mobile.data.Data

@Composable
fun BookingPage(
    showSnackBar: (String) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 30.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),

        ) {
        items(Data.bookings.value) { item ->
            BookingCard(
                bookingNumber = item.bookingNumber,
                roomNumber = item.roomNumber,
                startTime = item.startTime,
                endTime = item.endTime,
                onButtonClick = {
                    showSnackBar("Уведомление установленно на ${item.startTime}")
                }
            )
        }
    }
}