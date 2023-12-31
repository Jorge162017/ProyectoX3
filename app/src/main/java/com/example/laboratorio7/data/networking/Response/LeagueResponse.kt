package com.example.laboratorio7.data.networking.Response

import com.google.gson.annotations.SerializedName

data class leaguesDataResponse(val leagues: List<LeagueResponse>)


data class leagueDataResponse(val saveLeague: LeagueResponse)

data class leagueImageDataResponse(val league: LeagueResponse)


data class leagueTeamDataResponse(val ls: LeagueResponseTeam)


data class LeagueResponse(
    @SerializedName("_id") val id: String,
    @SerializedName("teams") val teams: Array<String>,
    @SerializedName("sessions") val sessions:  Array<String>,
    @SerializedName("name") val name: String,
    @SerializedName("season") val season: String,
    @SerializedName("description") val description: String,
    @SerializedName("logo") val logo: String,
)

data class LeagueResponseTeam(
    @SerializedName("_id") val id: String,
    @SerializedName("teams") val teams: Array<TeamResponse>,
    @SerializedName("sessions") val sessions:  Array<String>,
    @SerializedName("name") val name: String,
    @SerializedName("season") val season: String,
    @SerializedName("description") val description: String,
    @SerializedName("logo") val logo: String,
)