package com.example.laboratorio7.data.repository


import android.graphics.Bitmap
import com.example.laboratorio7.data.networking.Response.leagueDataResponse
import com.example.laboratorio7.data.networking.Response.leagueImageDataResponse
import com.example.laboratorio7.data.networking.Response.leaguesDataResponse
import com.example.laboratorio7.data.networking.WebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeRepository( private val webService: WebService = WebService()) {


    suspend fun getLeagues(token:String): leaguesDataResponse{
        return withContext(Dispatchers.IO) {
            webService.getLeagues(token)
        }
    }




    suspend fun saveLeague(token:String, name:String, season:String, description: String): leagueDataResponse {
        return withContext(Dispatchers.IO) {
            webService.saveLeague(token, name, season, description)
        }
    }


    suspend fun uploadImageLeague(bitmap: Bitmap?, id:String): leagueImageDataResponse {
        return withContext(Dispatchers.IO) {
            webService.uploadImageLeague(bitmap,id)
        }
    }


}