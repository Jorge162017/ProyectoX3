package com.example.laboratorio7.data.networking.Response

import com.google.gson.annotations.SerializedName

data class MatchResponse(
    @SerializedName("_id") val id: String,
    @SerializedName("playersOne") val playersOne: Array<PlayerResponse>,
    @SerializedName("playersSecond") val playersSecond:  Array<PlayerResponse>,
    @SerializedName("leagues") val leagues: Array<String>,
    @SerializedName("goalsFirst") val goalsFirst: Number,
    @SerializedName("goalsSecond") val goalsSecond: Number,
)


data class MatchResponseDelete(
    @SerializedName("remove") val remove: String,
)

data class MatchResponseCreate(
    @SerializedName("date") val date: String,
)


