package com.example.press_f_mobile.data

import com.example.press_f_mobile.R

data class Event(
    val id: Int = -1,
    val imageId: Int = R.drawable.a9a9a9,
    val title: String = "-",
    val date: String = "--.--.----",
    val description: String = "-",
    val fullDescription: String = "-",
    var participantsNumber: Int = 0,
    var userIsParticipant: Boolean = false,
)
