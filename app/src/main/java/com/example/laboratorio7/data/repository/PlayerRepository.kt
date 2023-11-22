package com.example.laboratorio7.data.repository

import com.example.laboratorio7.data.networking.Response.PlayersDataResponse
import com.example.laboratorio7.data.networking.Response.leaguesDataResponse
import com.example.laboratorio7.data.networking.WebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PlayerRepository ( private val webService: WebService = WebService()) {



    suspend fun getPlayersTeam(token:String): PlayersDataResponse {
        return withContext(Dispatchers.IO) {
            webService.getPlayersTeam(token)
        }
    }
}