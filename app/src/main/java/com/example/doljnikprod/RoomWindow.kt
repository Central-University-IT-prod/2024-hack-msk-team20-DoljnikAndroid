package com.example.doljnikprod

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

class RoomWindow (private val thisRoom: Room, private val user: Person, var userGivedDebt: MutableState<Person>) : IDrawable {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    override fun Draw(navController: NavHostController) {

        var total = 0

        var debtors = remember { mutableMapOf<String, Int>() }

        val debtorsNames = remember { mutableListOf<String>() }
        val debtorsDebt = remember { mutableListOf<Int>() }
        debtorsDebt.clear()
        debtorsNames.clear()

        for (i in thisRoom.users) {
            if (user.name == i.name) {
                debtors = i.debtors
            }
        }

        for (i in debtors) {
            if (user.name != i.key) {
                debtorsNames.add(i.key)
                debtorsDebt.add(i.value)
                total += i.value
            }
        }

        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            Box(modifier = Modifier.fillMaxWidth().size(100.dp)){
                Row (horizontalArrangement = Arrangement.SpaceBetween){
                    IconButton(modifier = Modifier.size(80.dp),

                        onClick = {
                            navController.popBackStack()
                            navController.navigate(Routes.ListRooms.route)
                        } ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "", modifier = Modifier.size(35.dp))
                    }
                    Spacer(modifier = Modifier.size(10.dp))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(80.dp),
                        shape = RoundedCornerShape(20.dp),

                        onClick = {
                            navController.navigate(Routes.History.route)
                        }
                    ) {
                        Text("История", fontSize = 35.sp)
                    }
//                    IconButton(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .size(80.dp),
//                        onClick = {
//                            navController.navigate(Routes.History.route)
//                        }
//                    ) {
//                        Icon(Icons.Outlined.Br, contentDescription = "", modifier = Modifier.size(35.dp))
//                    }
                }
            }
            Box(
                modifier = Modifier
                    .weight(0.8f)
                    .fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {
                Text(
                    thisRoom.name + "\nИтог: " + total.toString(),
                    fontSize = 40.sp,
                    style = TextStyle(textIndent = TextIndent(20.sp, 20.sp))
                )
            }
            LazyColumn(modifier = Modifier
                .weight(4f)
                .fillMaxSize()) {
                itemsIndexed(debtorsNames) { i, it ->
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(70.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1.5f)
                                .fillMaxSize(),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Text(
                                it,
                                fontSize = 30.sp,
                                style = TextStyle(textIndent = TextIndent(5.sp, 5.sp))
                            )
                        }
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxSize(),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Text(debtorsDebt[i].toString(), fontSize = 30.sp)
                        }
                        Box(
                            modifier = Modifier
                                .weight(0.8f)
                                .fillMaxSize(),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            IconButton(modifier = Modifier.size(80.dp),
                                onClick = {
                                    userGivedDebt.value = thisRoom.users[i + 1]
                                    navController.navigate(Routes.Repayment.route)
                                }) {
                                Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "", modifier = Modifier.size(40.dp))
                            }
                        }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(120.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    modifier = Modifier
                        .size(350.dp, 80.dp),
                    shape = RoundedCornerShape(20.dp),
                    onClick = {
                        navController.navigate(Routes.AddCheck.route)
                    }
                ) {
                    Text("Добавить чек", fontSize = 35.sp)
                }
            }
        }
    }


}