package com.example.laboratorio7.data.repository

import android.graphics.Bitmap
import com.example.laboratorio7.data.networking.Response.MatchResponseCreate
import com.example.laboratorio7.data.networking.Response.MatchResponseDelete
import com.example.laboratorio7.data.networking.Response.leagueDataResponse
import com.example.laboratorio7.data.networking.Response.leagueImageDataResponse
import com.example.laboratorio7.data.networking.Response.leaguesDataResponse
import com.example.laboratorio7.data.networking.Response.sessionsDataResponse
import com.example.laboratorio7.data.networking.WebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SessionRepository( private val webService: WebService = WebService()) {


    suspend fun getSession(token:String, id: String): sessionsDataResponse {
        return withContext(Dispatchers.IO) {
            webService.getSession(token, id)
        }
    }


    suspend fun removeMatch(token:String, id: String): MatchResponseDelete {
        return withContext(Dispatchers.IO) {
            webService.removeMatch(token, id)
        }
    }


    suspend fun createMatch(token:String, id: String, date:String): MatchResponseCreate {
        return withContext(Dispatchers.IO) {
            webService.createMatch(token, id, date)
        }
    }





}