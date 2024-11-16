package com.example.doljnikprod

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainClass {

    private val rooms = mutableListOf<Room>()

    private val thisRoomIndex: MutableState<Int>

    private var userGivedDebt : MutableState<Person>

    private var user = Person("Петя")

    init {
        rooms.add(Room(0, "Поездка в Индию", "lol", user.name))
        rooms.add(Room(rooms.size - 1, "Поездка во Францию", "lalka", user.name))
        rooms[0].addPerson("Вася")
        rooms[0].addPerson("Геннадий")
        rooms[0].addPerson("Лина")
        rooms[0].addPerson("asd")
        rooms[0].addPerson("sf")
        rooms[0].addPerson("dfg")
        rooms[0].addPerson("zxc")
        rooms[0].addPerson("xcv")
        rooms[0].addPerson("cvb")
        rooms[0].addPerson("vbn")
        rooms[0].addPerson("bnm")
        rooms[0].addPerson("nm")

        rooms[1].addPerson("фыва")
        rooms[1].addPerson("ячсм")
        rooms[1].addPerson("ывап")
        thisRoomIndex = mutableStateOf(0)
        userGivedDebt = mutableStateOf<Person>(rooms[0].users[1])
    }

    @Composable
    fun MainFunc() {
        val navController = rememberNavController()
        var thisDrawable: IDrawable
        NavHost(navController = navController, startDestination = Routes.ListRooms.route) {

            composable(Routes.Room.route) {

                var userIndex: Int = 0
                for ((i, u) in rooms[thisRoomIndex.value].users.withIndex()) {
                    if (u.name == user.name) {
                        userIndex = i
                        break
                    }
                }
                user = rooms[thisRoomIndex.value].users[userIndex]
                thisDrawable = RoomWindow(rooms[thisRoomIndex.value], user, userGivedDebt)
                thisDrawable.Draw(navController)
            }
            composable(Routes.ListRooms.route) {
                thisDrawable = ListRoomsWindow(rooms, thisRoomIndex)
                thisDrawable.Draw(navController)
            }
            composable(Routes.AddCheck.route) {
                thisDrawable = AddCheckWindow(rooms[thisRoomIndex.value], user)
                thisDrawable.Draw(navController)
            }
            composable(Routes.SignIn.route) {
                thisDrawable = SignInWindow()
                thisDrawable.Draw(navController)
            }
            composable(Routes.SignUp.route) {
                thisDrawable = SignUpWindow()
                thisDrawable.Draw(navController)
            }
            composable(Routes.CreateRoom.route) {
                thisDrawable = CreateRoomWindow(rooms, user.name)
                thisDrawable.Draw(navController)
            }
            composable(Routes.History.route) {
                thisDrawable = HistoryWindow(user.history)
                thisDrawable.Draw(navController)
            }
            composable(Routes.Repayment.route) {
                thisDrawable = RepaymentWindow(rooms[thisRoomIndex.value], userGivedDebt.value, user)
                thisDrawable.Draw(navController)
            }
            composable(Routes.JoinToRoom.route) {
                thisDrawable = JoinToRoomWindow(rooms)
                thisDrawable.Draw(navController)
            }
            composable(Routes.StartWindow.route) {
                thisDrawable = StartWindow()
                thisDrawable.Draw(navController)
            }
        }
    }
}