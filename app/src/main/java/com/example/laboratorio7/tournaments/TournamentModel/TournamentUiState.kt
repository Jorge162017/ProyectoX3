package com.example.laboratorio7.tournaments.TournamentModel

import com.example.laboratorio7.data.networking.Response.LeagueResponse

data class TournamentUiState (
    val saveLeague: LeagueResponse,
    val loading: Boolean = false,
)
