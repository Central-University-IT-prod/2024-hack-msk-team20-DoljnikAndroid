package com.example.doljnikprod

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

class SignUpWindow : IDrawable {
    @Composable
    override fun Draw(navController: NavHostController) {
        var login = remember { mutableStateOf("") }
        var password = remember { mutableStateOf("") }
        var confirmPassword = remember { mutableStateOf("") }


        Column(verticalArrangement = Arrangement.SpaceAround) {
            BackButton({
                navController.popBackStack()
                navController.navigate(Routes.StartWindow.route)
            })
            // Логин
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(80.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Text(
                    "Логин",
                    fontSize = 40.sp,
                    style = TextStyle(textIndent = TextIndent(20.sp, 20.sp))
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(80.dp)
            ) {
                TextField(
                    login.value, modifier = Modifier.fillMaxSize(),
                    textStyle = TextStyle(fontSize = 25.sp),
                    onValueChange = { login.value = it },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii)
                )
            }
            // Пароль
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(80.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Text(
                    "Пароль",
                    fontSize = 40.sp,
                    style = TextStyle(textIndent = TextIndent(20.sp, 20.sp))
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(80.dp)
            ) {
                TextField(
                    password.value, modifier = Modifier.fillMaxSize(),
                    textStyle = TextStyle(fontSize = 25.sp),
                    visualTransformation = PasswordVisualTransformation(),
                    onValueChange = { password.value = it },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
            }
            // Повторить пароль
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(80.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Text(
                    "Повторите пароль",
                    fontSize = 40.sp,
                    style = TextStyle(textIndent = TextIndent(20.sp, 20.sp))
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(80.dp)
            ) {
                TextField(
                    confirmPassword.value, modifier = Modifier.fillMaxSize(),
                    textStyle = TextStyle(fontSize = 25.sp),
                    visualTransformation = PasswordVisualTransformation(),
                    onValueChange = { confirmPassword.value = it },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
            }


            Spacer(modifier = Modifier
                .fillMaxWidth()
                .size(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(80.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(modifier = Modifier.size(350.dp, 80.dp),
                    shape = RoundedCornerShape(20.dp),
                    onClick = {

                    }) {
                    Text("Добавить", fontSize = 35.sp)
                }
            }


        }
    }
}