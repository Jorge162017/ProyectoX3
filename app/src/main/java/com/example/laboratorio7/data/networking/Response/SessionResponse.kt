package com.example.laboratorio7.data.networking.Response

import com.google.gson.annotations.SerializedName
data class sessionsDataResponse(val session: List<SessionResponse>)

data class SessionResponse(
    @SerializedName("_id") val id: String,
    @SerializedName("matchs") val matchs: Array<MatchResponse>,
    @SerializedName("leagues") val leagues:  Array<String>,
    @SerializedName("name") val name: String,
    @SerializedName("dateFirst") val dateFirst: String,
    @SerializedName("dateSecond") val dateSecond: String,
)