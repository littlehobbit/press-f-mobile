package com.example.press_f_mobile.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.press_f_mobile.R
import com.example.press_f_mobile.bottom_navigation.Page
import com.example.press_f_mobile.components.CustomButton
import com.example.press_f_mobile.components.input_field.CustomInput
import com.example.press_f_mobile.ui.theme.OrangeColor

@Composable
fun SignInPage(navController: NavHostController) {
    var login by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.height(260.dp),
            contentScale = ContentScale.FillHeight,
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo"
        )
        Spacer(modifier = Modifier.height(50.dp))
        CustomInput(
            modifier = Modifier.padding(horizontal = 30.dp),
            text = login,
            hint = "Email",
            onValueChange = {
                login = it
            })
        Spacer(modifier = Modifier.height(10.dp))
        CustomInput(
            modifier = Modifier.padding(horizontal = 30.dp),
            text = password,
            hint = "Password",
            onValueChange = {
                password = it
            })
        Spacer(modifier = Modifier.height(100.dp))
        CustomButton(
            modifier = Modifier.width(270.dp),
            text = "Войти",
            shape = RoundedCornerShape(5.dp),
            backgroundColor = OrangeColor,
            textStyle = MaterialTheme.typography.h3,
            onClickFunc = {
                println("sign in")
                navController.navigate(Page.News.route)
            },
            verticalPadding = 10.dp,

            )
        Spacer(modifier = Modifier.height(10.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Нет аккаунта?",
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                modifier = Modifier.clickable {
                    navController.navigate(Page.SignUp.route)
                },
                text = "Зарегестрируйтесь",
                style = MaterialTheme.typography.body1,
                color = OrangeColor
            )
        }
    }
}