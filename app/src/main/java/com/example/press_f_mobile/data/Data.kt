package com.example.press_f_mobile.data

import androidx.compose.runtime.mutableStateOf
import com.example.press_f_mobile.R

object Data {
    val events = mutableStateOf(
        listOf(
            Event(
                id = 1,
                imageId = R.drawable.mk_img,
                title = "Чемпионат “Press F” по Mortal Combat",
                date = "09.09.2022",
                fullDescription = "Мегакрутой чемпионат по МК среди профессионалов!\n" +
                        "\n" +
                        "Призовой фонд: шава и звание абобуса\n" +
                        "\n" +
                        "Всем участникам приходить в 15:00 для регистрации.",
                description = "Успей записаться и выиграть кубок абобуса!",
                participantsNumber = 10
            ),
            Event(
                id = 2,
                imageId = R.drawable.ufc,
                title = "Локальный турнир по игре UFC 3",
                date = "21.01.2022",
                fullDescription = "Отборные вафельники из команды \"Чистый Чай\" отметили день рождения одного из участников (Кутя)\n" +
                        "\n" +
                        "У игроков был неограниченный запас энергии, пиццы, роллов и девочек;)\n" +
                        "\n" +
                        "После утомительных боёв игроки перешли к душевным историям из детства и поиграли на гитарах\n",
                description = "День рождения одного из участников!",
                participantsNumber = 5
            ),
            Event(
                id = 3,
                imageId = R.drawable.mk_img,
                title = "Чемпионат “Press F” по Mortal Combat",
                date = "09.09.2022",
                fullDescription = "Мегакрутой чемпионат по МК среди профессионалов!\n" +
                        "\n" +
                        "Призовой фонд: шава и звание абобуса\n" +
                        "\n" +
                        "Всем участникам приходить в 15:00 для регистрации.",
                description = "Успей записаться и выиграть кубок абобуса!",
                participantsNumber = 10
            ),
            Event(
                id = 4,
                imageId = R.drawable.mk_img,
                title = "Чемпионат “Press F” по Mortal Combat",
                date = "09.09.2022",
                fullDescription = "Мегакрутой чемпионат по МК среди профессионалов!\n" +
                        "\n" +
                        "Призовой фонд: шава и звание абобуса\n" +
                        "\n" +
                        "Всем участникам приходить в 15:00 для регистрации.",
                description = "Успей записаться и выиграть кубок абобуса!",
                participantsNumber = 10
            ),
            Event(
                id = 5,
                imageId = R.drawable.mk_img,
                title = "Чемпионат “Press F” по Mortal Combat",
                date = "09.09.2022",
                fullDescription = "Мегакрутой чемпионат по МК среди профессионалов!\n" +
                        "\n" +
                        "Призовой фонд: шава и звание абобуса\n" +
                        "\n" +
                        "Всем участникам приходить в 15:00 для регистрации.",
                description = "Успей записаться и выиграть кубок абобуса!",
                participantsNumber = 10
            ),
            Event(
                id = 6,
                imageId = R.drawable.mk_img,
                title = "Чемпионат “Press F” по Mortal Combat",
                date = "09.09.2022",
                fullDescription = "Мегакрутой чемпионат по МК среди профессионалов!\n" +
                        "\n" +
                        "Призовой фонд: шава и звание абобуса\n" +
                        "\n" +
                        "Всем участникам приходить в 15:00 для регистрации.",
                description = "Успей записаться и выиграть кубок абобуса!",
                participantsNumber = 10
            ),
        )
    )

    var bookings = mutableStateOf(listOf<Booking>())

    val rooms = mutableStateOf(
        listOf(
            Room(
                roomNumber = 1,
                inventory = listOf(
                    "5x PC с GTX1080TI"
                ),
            ),
            Room(
                roomNumber = 2,
                inventory = listOf(
                    "Playstation 5",
                    "Проектор"
                ),
            ),
            Room(
                roomNumber = 3,
                inventory = listOf(
                    "XBox 360",
                    "Guitar Hero",
                    "Плазма"
                ),
            ),
            Room(
                roomNumber = 4,
                inventory = listOf(
                    "Пуфики",
                    "Настолки"
                ),
            ),
            Room(
                roomNumber = 5,
                inventory = listOf(
                    "Пуфики",
                    "Настолки"
                ),
            ),
            Room(
                roomNumber = 6,
                inventory = listOf(
                    "Пуфики",
                    "Настолки"
                ),
            ),
            Room(
                roomNumber = 7,
                inventory = listOf(
                    "Пуфики",
                    "Настолки"
                ),
            ),
        )
    )

    val news = mutableStateOf(
        listOf(
            News(
                imageId = R.drawable.ps_plus,
                title = "Sony представила обновлённую подписку PS Plus ",
                description = "Запуск начнётся в июне."
            ),
            News(
                imageId = R.drawable.news_arcade,
                title = "Закуплены новые аркадные автоматы",
            ),
            News(
                imageId = R.drawable.news_arcade,
                title = "Был определён призовой фонд турнира Dungeon Masters",
            ),
            News(
                imageId = R.drawable.news_arcade,
                title = "Был определён призовой фонд турнира Dungeon Masters",
            ),
            News(
                imageId = R.drawable.news_arcade,
                title = "Был определён призовой фонд турнира Dungeon Masters",
            ),
            News(
                imageId = R.drawable.news_arcade,
                title = "Был определён призовой фонд турнира Dungeon Masters",
            ),
            News(
                imageId = R.drawable.news_arcade,
                title = "Был определён призовой фонд турнира Dungeon Masters",
            ),
            News(
                imageId = R.drawable.news_arcade,
                title = "Был определён призовой фонд турнира Dungeon Masters",
            ),
            News(
                imageId = R.drawable.news_arcade,
                title = "Был определён призовой фонд турнира Dungeon Masters",
            ),
        )
    )
}
