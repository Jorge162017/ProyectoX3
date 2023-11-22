package com.example.laboratorio7.tournaments.itemTournament.MatchModel

import com.example.laboratorio7.data.networking.Response.SessionResponse

data class MatchUiState (
    val session: List<SessionResponse>,
    val loading: Boolean = false,
)
