package com.example.press_f_mobile.components.input_field

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.press_f_mobile.ui.theme.TillColor

@Composable
fun CustomInput(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle(),
    singleLine: Boolean = true,
) {
    val hintIsVisible = remember {
        mutableStateOf(true)
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .border(
                3.dp,
                TillColor,
                RoundedCornerShape(10.dp)
            )
            .padding(
                horizontal = 16.dp,
                vertical = 16.dp
            )
    ) {
        BasicTextField(
            value = text,
            onValueChange = onValueChange,
            singleLine = singleLine,
            textStyle = textStyle,
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged {
                    hintIsVisible.value = !it.isFocused && text.isBlank()
                }
        )
        if (hintIsVisible.value) {
            Text(text = hint, style = textStyle, color = Color.DarkGray)
        }
    }
}