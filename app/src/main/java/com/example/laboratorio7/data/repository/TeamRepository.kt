package com.example.laboratorio7.data.repository

import com.example.laboratorio7.data.networking.Response.teamDataResponse
import com.example.laboratorio7.data.networking.Response.teamsDataResponse
import com.example.laboratorio7.data.networking.WebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TeamRepository( private val webService: WebService = WebService()){
    suspend fun getTeams(token:String): teamsDataResponse {
        return withContext(Dispatchers.IO) {
            webService.getTeams(token)
        }
    }


    suspend fun saveTeam(token: String, name: String, players: Array<String>, gc: Number, gd: Number,
                         gf: Number, pe: Number, pg: Number, pj: Number, pp: Number, points: Number): teamDataResponse {
        return withContext(Dispatchers.IO) {
            webService.saveTeam(token, name, players, gc, gd, gf, pe, pg, pj, pp, points)
        }
    }
}


