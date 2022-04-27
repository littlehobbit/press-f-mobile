package com.example.press_f_mobile.bottom_navigation

import com.example.press_f_mobile.R

sealed class Page (
    val route: String,
    val title: String,
    val icon: Int
) {
    object Loading: Page(
        route = "loading",
        title = "Загрузка",
        icon = R.drawable.ic_launcher_foreground
    )

    object SignIn: Page(
        route = "sign-in",
        title = "Вход",
        icon = R.drawable.ic_launcher_foreground
    )

    object SignUp: Page(
        route = "sign-up",
        title = "Регистрация",
        icon = R.drawable.ic_launcher_foreground
    )

    object News: Page(
        route = "news",
        title = "Новости",
        icon = R.drawable.news_icon
    )

    object Events: Page(
        route = "events",
        title = "Мероприятия",
        icon = R.drawable.events_icon
    )

    object DetailedEvent: Page(
        route = "detailed-event/{id}",
        title = "Конкретное событие",
        icon = R.drawable.events_icon
    )

    object Booking: Page(
        route = "booking",
        title = "Брони",
        icon = R.drawable.booking_icon
    )

    object Rooms: Page(
        route = "rooms",
        title = "Комнаты",
        icon = R.drawable.rooms_icon
    )
}