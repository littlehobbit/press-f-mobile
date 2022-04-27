package com.example.press_f_mobile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.press_f_mobile.ui.theme.SubwhiteColor

@Composable
fun NewsCard(
    modifier: Modifier = Modifier,
    imageId: Int = -1,
    title: String = "",
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        elevation = 10.dp,
    ) {
        Row {
            if (imageId == -1) {
                Box(
                    modifier = Modifier
                        .height(120.dp)
                        .width(130.dp)
                        .background(SubwhiteColor),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator()
                }
            } else {
                Image(
                    modifier = Modifier
                        .height(120.dp)
                        .width(130.dp),
                    painter = painterResource(id = imageId),
                    contentDescription = title,
                    contentScale = ContentScale.Crop
                )
            }
            Box(
                modifier = Modifier.padding(
                    top = 10.dp,
                    start = 15.dp,
                    end = 15.dp,
                    bottom = 10.dp
                )
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h4
                )
            }
        }
    }
}