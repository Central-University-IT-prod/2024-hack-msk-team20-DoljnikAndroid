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
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

class CreateRoomWindow (val rooms : MutableList<Room>, val userName:String) : IDrawable {

    fun CreateRoom(index: Int, name: MutableState<String>, password: MutableState<String>){
        if (name.value != ""){
            rooms.add(Room(index, name.value, password.value, userName))
        }
    }

    @Composable
    override fun Draw(navController: NavHostController) {

        val name = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }

        Column(verticalArrangement = Arrangement.SpaceAround) {
            BackButton({
                navController.popBackStack()
                navController.navigate(Routes.ListRooms.route)
            })
            // Название
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(80.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Text(
                    "Название",
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
                    name.value, modifier = Modifier.fillMaxSize(),
                    textStyle = TextStyle(fontSize = 25.sp),
                    onValueChange = { name.value = it },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )
            }

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
                    visualTransformation = PasswordVisualTransformation(),
                    textStyle = TextStyle(fontSize = 25.sp),
                    onValueChange = { password.value = it },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,
                    )
                )
            }

            Spacer(modifier = Modifier.fillMaxWidth().size(20.dp))

            Box(modifier = Modifier
                .fillMaxWidth()
                .size(80.dp)) {
                Button(modifier = Modifier.fillMaxSize(),
                    shape = RoundedCornerShape(20.dp),
                    onClick = {
                        CreateRoom(rooms.size - 1, name, password)
                        navController.popBackStack()
                        navController.navigate(Routes.ListRooms.route)
                    }) {
                    Text("Создать", fontSize = 35.sp)
                }
            }

        }


    }


}