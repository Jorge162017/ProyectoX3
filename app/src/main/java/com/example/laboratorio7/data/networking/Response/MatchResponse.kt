package com.example.laboratorio7.data.networking.Response

import com.google.gson.annotations.SerializedName


data class  sessionsDataResponse (val session: List<SessionResponse>)

  data class SessionResponse(
      @SerializedName("message") val message: String,
      @SerializedName("session") val sessions: List<String>
      )