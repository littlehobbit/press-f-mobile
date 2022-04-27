package com.example.press_f_mobile.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.press_f_mobile.components.MainNewsCard
import com.example.press_f_mobile.components.NewsCard
import com.example.press_f_mobile.data.Data
import com.example.press_f_mobile.ui.theme.BlackColor

@Composable
fun NewsPage(navController : NavHostController) {
        LazyColumn(
            contentPadding = PaddingValues(vertical = 30.dp, horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),

            ) {

            item {
                val mainNews = Data.news.value[0]
                MainNewsCard(
                    imageId = mainNews.imageId,
                    title = mainNews.title,
                    description = mainNews.description,
                )
            }

            item {
                Column() {
                    Divider(
                        color = BlackColor,
                        thickness = 1.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 100.dp)
                    )
                }
            }

            items(Data.news.value) { item ->
                NewsCard(
                    modifier = Modifier
                        .fillMaxWidth(),
                    imageId = item.imageId,
                    title = item.title,
                )
            }
        }
}