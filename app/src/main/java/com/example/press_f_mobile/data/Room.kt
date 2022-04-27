package com.example.press_f_mobile.data

data class Room(
    val roomNumber: Int = 1,
    val inventory: List<String> = listOf(
        "item 1",
        "item 2",
        "item 3",
    ),
    var isBooked: Boolean = false
)
