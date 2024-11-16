package com.example.doljnikprod

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

class StartWindow : IDrawable {
    @Composable
    override fun Draw(navController: NavHostController) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(100.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Button(modifier = Modifier
                    .size(350.dp, 80.dp),
                    shape = RoundedCornerShape(20.dp),
                    onClick = {
                        navController.navigate(Routes.SignIn.route)
                    }) {
                    Text("Вход", fontSize = 40.sp)
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(120.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Button(modifier = Modifier
                    .size(350.dp, 80.dp),
                    shape = RoundedCornerShape(20.dp),
                    onClick = {
                        navController.navigate(Routes.SignUp.route)
                    }) {
                    Text("Регистрация", fontSize = 40.sp)
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(120.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Button(modifier = Modifier
                    .size(350.dp, 80.dp),
                    shape = RoundedCornerShape(20.dp),
                    onClick = {
                        navController.navigate(Routes.ListRooms.route)
                    }) {
                    Text("Пропустить", fontSize = 40.sp)
                }
            }
        }

    }

}