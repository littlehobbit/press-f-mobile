package com.example.press_f_mobile.data

data class Booking(
    val id: Int = 0,
    val bookingNumber: String = "-",
    val roomNumber: String = "-",
    val startTime: String = "--:-- --.--.----",
    val endTime: String = "--:-- --.--.----"
)
