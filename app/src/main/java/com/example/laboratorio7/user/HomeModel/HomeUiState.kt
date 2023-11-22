package com.example.laboratorio7.user.HomeModel

import com.example.laboratorio7.data.networking.Response.LeagueResponse

data class HomeUiState (
    val leagues: List<LeagueResponse>,
    val loading: Boolean = false,
)
