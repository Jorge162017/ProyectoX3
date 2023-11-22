package com.example.laboratorio7.tournaments.itemTournament.TeamsModel

import com.example.laboratorio7.data.networking.Response.LeagueResponseTeam
import com.example.laboratorio7.data.networking.Response.TeamResponse
import com.example.laboratorio7.data.networking.Response.teamsDataResponse


data class TeamUiState (
    val ls: LeagueResponseTeam,
    val loading: Boolean = false,
)

data class PositionUiState (
    val teams: List<TeamResponse>,
    val loading: Boolean = false,
)
