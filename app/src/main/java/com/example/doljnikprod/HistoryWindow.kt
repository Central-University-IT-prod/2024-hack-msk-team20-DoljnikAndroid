package com.example.doljnikprod

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

class HistoryWindow(val history : MutableList<Transaction>) : IDrawable {
    @Composable
    override fun Draw(navController: NavHostController) {
        Column(verticalArrangement = Arrangement.SpaceAround) {
            BackButton { navController.popBackStack()
                navController.navigate(Routes.Room.route) }
            LazyColumn(modifier = Modifier.
                weight(1f)
                .fillMaxSize()) {
                itemsIndexed(history) { i, it ->
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
                                it.name,
                                fontSize = 30.sp,
                                style = TextStyle(textIndent = TextIndent(5.sp, 5.sp))
                            )
                        }
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxSize(),

                        ) {
                            Text(it.money.toString(), fontSize = 30.sp)
                        }
                    }
                }
            }

        }



    }


}