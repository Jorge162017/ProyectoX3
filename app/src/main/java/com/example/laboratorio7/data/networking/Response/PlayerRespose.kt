package com.example.laboratorio7.data.networking.Response

import com.google.gson.annotations.SerializedName

data class  PlayersDataResponse(val players: List<PlayerResponse>)

data class PlayerDataResponse (val setPlayerToTeam: PlayerResponse)

data class PlayerResponse(
    @SerializedName("_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("dorsal") val dorsal:  String,
    @SerializedName("position") val position: String,
    @SerializedName("goal") val goal: String,
    @SerializedName("cardA") val cardA: String,
    @SerializedName("cardR") val cardR: String,
    @SerializedName("cardT") val cardT: String,
)