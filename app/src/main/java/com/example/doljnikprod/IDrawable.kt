package com.example.doljnikprod

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

interface IDrawable {
    @Composable
    fun Draw(navController : NavHostController)
}