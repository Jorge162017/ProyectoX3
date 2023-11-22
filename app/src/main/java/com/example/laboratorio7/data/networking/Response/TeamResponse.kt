package com.example.laboratorio7.data.networking.Response

import com.google.gson.annotations.SerializedName

data class teamsDataResponse(val teams: List<TeamResponse>)

data class teamDataResponse(val saveTeam: TeamResponse)
data class TeamResponse (
    @SerializedName("_id") val id: String,
    @SerializedName("players") val players: Array<String>,
    @SerializedName("name") val name:  String,
    @SerializedName("GC") val gc: Number,
    @SerializedName("GD") val gd: Number,
    @SerializedName("PE") val pe: Number,
    @SerializedName("PG") val pg: Number,
    @SerializedName("PJ") val pj: Number,
    @SerializedName("PP") val pp: Number,
    @SerializedName("GF") val gf: Number,
    @SerializedName("points") val points: Number,
    @SerializedName("Logo") val logo: String,
)
