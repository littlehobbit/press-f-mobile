package com.example.press_f_mobile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.press_f_mobile.R
import com.example.press_f_mobile.ui.theme.OrangeColor
import com.example.press_f_mobile.ui.theme.SubwhiteColor
import com.example.press_f_mobile.ui.theme.TillColor

@Composable
fun MainNewsCard(
    modifier: Modifier = Modifier,
    imageId: Int = -1,
    title: String = "",
    description: String = "",
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        elevation = 10.dp,
    ) {
        Column {
            if (imageId == -1) {
                Box(
                    modifier = Modifier
                        .height(190.dp)
                        .fillMaxWidth()
                        .background(SubwhiteColor),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator()
                }
            } else {
                Image(
                    modifier = Modifier
                        .height(190.dp)
                        .fillMaxWidth(),
                    painter = painterResource(id = imageId),
                    contentDescription = title,
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier.padding(
                    top = 15.dp,
                    start = 15.dp,
                    end = 15.dp,
                    bottom = 10.dp
                )
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h3
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}