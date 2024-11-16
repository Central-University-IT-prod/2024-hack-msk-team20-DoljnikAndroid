package com.example.doljnikprod

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

class ListRoomsWindow(val rooms: MutableList<Room>, private val thisRoomIndex: MutableState<Int>) : IDrawable {
    @Composable
    override fun Draw(navController: NavHostController) {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            BackButton {
                navController.popBackStack()
                navController.navigate(Routes.StartWindow.route)
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .size(25.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .size(80.dp),
                contentAlignment = Alignment.CenterStart){
                Text("Комнаты", fontSize = 40.sp)
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .size(10.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .size(100.dp),
                contentAlignment = Alignment.BottomCenter) {
                Button(modifier = Modifier
                    .size(350.dp, 80.dp),
                    shape = RoundedCornerShape(20.dp),
                    onClick = {
                        navController.navigate(Routes.JoinToRoom.route)
                    }) {
                    Text("Присоединиться", fontSize = 30.sp)
                }
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .size(15.dp))
            Box(modifier = Modifier.fillMaxWidth().size(2.dp), contentAlignment = Alignment.Center){
                Box(modifier = Modifier.size(360.dp, 2.dp).background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(1.dp)))
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .size(20.dp))
            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .size(300.dp)
                .background(color = Color(0x01060FFF))) {
                itemsIndexed(rooms) { i, it ->
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .size(100.dp),
                        contentAlignment = Alignment.Center) {
                        Button(modifier = Modifier
                            .size(350.dp, 80.dp),
                            shape = RoundedCornerShape(20.dp),
                            onClick = {
                                thisRoomIndex.value = i
                                navController.navigate(Routes.Room.route)
                            }) {
                            Text(it.name, fontSize = 30.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .size(10.dp))
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
                Button(modifier = Modifier.size(80.dp),
                    onClick = {
                        navController.navigate(Routes.CreateRoom.route)
                    }) {
                    Text("+", fontSize = 40.sp)
                }
            }


        }
    }

}