package com.example.press_f_mobile.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BackdropScaffoldState
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.press_f_mobile.components.EventCard
import com.example.press_f_mobile.data.Data
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun EventsPage(
    navController: NavHostController,
    showSnackBar: (String) -> Unit
) {

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 30.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),

        ) {
        items(Data.events.value) { item ->
            EventCard(
                navController = navController,
                eventObj = item,
                onClick = {
                    item.userIsParticipant = !item.userIsParticipant
                    if (item.userIsParticipant) {
                        item.participantsNumber++
                        showSnackBar("Вы записались на мероприятие \"${item.title}\"")
                    } else {
                        item.participantsNumber--
                        showSnackBar("Вы отписались от мероприятия \"${item.title}\"")
                    }
                },
                setSelected = { item.userIsParticipant }
            )
        }
    }
}