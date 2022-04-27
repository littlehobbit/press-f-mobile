package com.example.press_f_mobile.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.press_f_mobile.components.NewsCard
import com.example.press_f_mobile.components.RoomCard
import com.example.press_f_mobile.data.Booking
import com.example.press_f_mobile.data.Data

@Composable
fun RoomsPage(
    showSnackBar: (String) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 30.dp, horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),

        ) {
        items(Data.rooms.value) { item ->
            RoomCard(
                modifier = Modifier
                    .fillMaxWidth(),
                onButtonClick = {
                    item.isBooked = !item.isBooked
                    if (item.isBooked) {
                        Data.bookings.value = Data.bookings.value.plus(
                            Booking(
                                bookingNumber = (1000..2000).random().toString(),
                                roomNumber = item.roomNumber.toString(),
                                startTime = "13:00 05.04.2022",
                                endTime = "19:30 05.04.2022"
                            ),
                        )
                        showSnackBar("Вы забронировали комнату №${item.roomNumber}. Скоро с вами свяжется менеджер.")
                    } else {
                        Data.bookings.value = Data.bookings.value.filter { booking -> booking.roomNumber.toInt() != item.roomNumber  }
                        showSnackBar("C комнаты №${item.roomNumber} снято бронирование.")
                    }
                    println(Data.bookings.value)
                },
                room = item,
                setSelected = { item.isBooked }
            )
        }
    }
}