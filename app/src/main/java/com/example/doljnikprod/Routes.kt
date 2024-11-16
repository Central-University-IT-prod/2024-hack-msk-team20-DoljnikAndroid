package com.example.doljnikprod

sealed class Routes(val route: String) {

    data object Room : Routes("Room")
    data object ListRooms : Routes("ListRooms")
    data object AddCheck : Routes("AddCheck")
    data object SignIn : Routes("SignIn")
    data object SignUp : Routes("SignUp")
    data object CreateRoom : Routes("CreateRoom")
    data object History : Routes("History")
    data object Repayment : Routes("Repayment")
    data object JoinToRoom : Routes("JoinToRoom")
    data object StartWindow : Routes("StartWindow")
}
