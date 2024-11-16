package com.example.doljnikprod

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request

val URL: String = "http://{{sensitive_data}}:8000"
val client = OkHttpClient()

data class Rooms(
    @SerializedName("id")
    val roomID: Long,
    @SerializedName("room_name")
    val name: String,
    @SerializedName("room_password")
    val password: String?
)

fun deserializeRooms(json: String): List<Rooms> {
    val gson = Gson()
    val typeToken = object : TypeToken<List<Rooms>>() {}
    return gson.fromJson(json, typeToken.type)
}

private fun getRoom() : List<Rooms> {
    var room: Rooms
    val request = Request.Builder()
        .url("$URL/api/api/rooms/")
        .build()
    var json: String
    client.newCall(request).execute().use { response ->
        if (!response.isSuccessful) throw Exception("Unexpected code: ${response.code}")
        json = response.body?.string()!! // Печать тела ответа
    }
    return deserializeRooms(json)
}