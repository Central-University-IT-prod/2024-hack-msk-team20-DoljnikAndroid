package com.example.doljnikprod

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

class RepaymentWindow(
    val thisRoom: Room,
    val userGivedDebt: Person,
    val userRepayer: Person
) : IDrawable {
    fun Repay(summStr: String, navController: NavHostController) {
        val summ = summStr.toIntOrNull()
        if (summ != null) {
            navController.popBackStack()
            navController.navigate(Routes.Room.route)
            thisRoom.setDebt(userRepayer, userGivedDebt, summ)
        }
    }

    @Composable
    override fun Draw(navController: NavHostController) {
        var summStr = remember { mutableStateOf("") }

        Column {
            BackButton() {
                navController.popBackStack()
                navController.navigate(Routes.Room.route)
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(120.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                TextField(
                    summStr.value, modifier = Modifier
                        .fillMaxWidth()
                        .size(70.dp),
                    textStyle = TextStyle(fontSize = 25.sp),
                    onValueChange = { summStr.value = it },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(120.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(modifier = Modifier
                    .size(350.dp, 80.dp),
                    shape = RoundedCornerShape(20.dp),
                    onClick = {
                        Repay(summStr.value, navController)
                    }) {
                    Text("Добавить", fontSize = 35.sp)
                }
            }
        }


    }

}