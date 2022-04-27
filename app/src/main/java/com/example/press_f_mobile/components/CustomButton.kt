package com.example.press_f_mobile.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.press_f_mobile.ui.theme.OrangeColor
import com.example.press_f_mobile.ui.theme.WhiteColor

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String = "",
    shape: Shape = RectangleShape,
    verticalPadding: Dp = 0.dp,
    horizontalPadding: Dp = 0.dp,
    backgroundColor: Color = OrangeColor,
    contentColor: Color = WhiteColor,
    textStyle: TextStyle = MaterialTheme.typography.body2,
    onClickFunc: () -> Unit,
) {
    TextButton(
        modifier = modifier,
        onClick = onClickFunc,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor
        ),
        contentPadding = PaddingValues(
            vertical = verticalPadding,
            horizontal = horizontalPadding
        ),
        shape = shape
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}